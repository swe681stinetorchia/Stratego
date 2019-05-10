package org.games.stratego.controller;

import  org.games.stratego.Services.RegexHelper;
import org.apache.logging.log4j.Logger;
import org.games.stratego.database.UserDBConnection;
import org.games.stratego.model.admin.GameCache;
import org.games.stratego.model.admin.Sessions;
import org.games.stratego.model.admin.User;
import org.games.stratego.model.gameplay.BoardView;
import org.games.stratego.model.gameplay.Game;
import org.apache.logging.log4j.LogManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

public class GameServlet extends HttpServlet {
    private final Logger log = LogManager.getLogger(getClass());
    //in your servlet or other web request handling code

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String storedToken;

        try {
            Object tok = session.getAttribute("csrfToken");

            if (tok==null)
            {
                request.setAttribute("message", "Not logged in.");

                session.setAttribute( "loggedIn", "false" );

                RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/html/loginError.jsp" );

                dispatcher.forward( request, response );

                return;
            }

            storedToken = (String) tok;
        }
        catch (ClassCastException cce)
        {
            cce.printStackTrace();

            request.setAttribute("message", "Not logged in.");

            session.setAttribute( "loggedIn", "false" );

            RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/html/loginError.jsp" );

            dispatcher.forward( request, response );

            return;
        }

        //go ahead and process ... do business logic here
        String sessionUserName = Sessions.checkSession(storedToken);

        if (sessionUserName==null)
        {
            //session token is stale or invalid
            session.removeAttribute("csrfToken");

            request.setAttribute("message", "Session is invalid.");

            session.setAttribute( "loggedIn", "false" );

            RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/html/loginError.jsp" );

            dispatcher.forward( request, response );

            return;
        }

        try {
            User userOne = new User(sessionUserName);

            String userTwoName = request.getParameter("opponent");

            User userTwo = new User(userTwoName);

            Game game = new Game(userOne, userTwo);

            String uuid = UUID.randomUUID().toString();

            GameCache.addGame(uuid, game);

            session.setAttribute("csrfToken", storedToken);

            session.setAttribute("game", game);

            session.setAttribute("gameId", uuid);

            BoardView boardView = new BoardView(game, storedToken);

            session.setAttribute("board", boardView);

            RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/html/setupgame.jsp" );

            dispatcher.forward( request, response );
        }
        catch (IllegalArgumentException iae)
        {
            session.setAttribute("csrfToken", storedToken);

            request.setAttribute("message", iae.getMessage());

            RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/html/userHome.jsp" );

            dispatcher.forward( request, response );
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        HttpSession session = request.getSession();

        String storedToken;

        try {
            Object tok = session.getAttribute("csrfToken");

            if(tok==null)
            {
                request.setAttribute("message", "Not logged in.");

                session.setAttribute( "loggedIn", "false" );

                RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/html/loginError.jsp" );

                dispatcher.forward( request, response );

                return;
            }

            storedToken = (String) tok;
        }
        catch (ClassCastException cce)
        {
            cce.printStackTrace();

            request.setAttribute("message", "Not logged in.");

            session.setAttribute( "loggedIn", "false" );

            RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/html/loginError.jsp" );

            dispatcher.forward( request, response );

            return;
        }

        //go ahead and process ... do business logic here
        String sessionUserName = Sessions.checkSession(storedToken);

        if (sessionUserName==null)
        {
            //session token is stale or invalid

            request.setAttribute("message", "Session is invalid");

            session.removeAttribute("csrfToken");

            session.setAttribute( "loggedIn", "false" );

            RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/html/loginError.jsp" );

            dispatcher.forward( request, response );

            return;
        }


        String action = request.getParameter("action");

        if (action.equals("open")) //request is used to open a new game and to open an existing game
        {
            String gameId = request.getParameter("gameId");

            Game game;

            try {
                game = GameCache.getGame(gameId);
            }
            catch(IllegalArgumentException iae)
            {
                session.setAttribute("csrfToken", storedToken);

                request.setAttribute( "message", iae );

                RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/html/userHome.jsp" );

                dispatcher.forward( request, response );

                return;
            }

            session.setAttribute("csrfToken", storedToken);

            session.setAttribute("game", game);

            session.setAttribute("gameId", gameId);

            BoardView boardView = new BoardView(game, storedToken);

            session.setAttribute("board", boardView);

            if (game.isGameStart())
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/playgame.jsp");

                dispatcher.forward( request, response );
            }
            else
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/setupgame.jsp");

                dispatcher.forward( request, response );
            }
        }
        if (action.equals("update")) //request is used update the board
        {
            Game game;

            String gameId;

            try {
                gameId = (String) session.getAttribute("gameId");

                game = GameCache.getGame(gameId);
            }
            catch(IllegalArgumentException iae)
            {
                request.setAttribute( "message", iae );

                session.removeAttribute("gameId");

                session.removeAttribute("board");

                session.removeAttribute("game");

                session.setAttribute("csrfToken", storedToken);

                RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/html/userHome.jsp" );

                dispatcher.forward( request, response );

                return;
            }
            catch (ClassCastException cce)
            {
                request.setAttribute( "message", "No game available." );

                session.removeAttribute("gameId");

                session.removeAttribute("board");

                session.removeAttribute("game");

                session.setAttribute("csrfToken", storedToken);

                RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/html/userHome.jsp" );

                dispatcher.forward( request, response );

                return;
            }
            
            if (game==null)
            {
                request.setAttribute( "message", "game is stale" );

                session.removeAttribute("gameId");

                session.removeAttribute("board");

                session.removeAttribute("game");

                session.setAttribute("csrfToken", storedToken);

                RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/html/userHome.jsp" );

                dispatcher.forward( request, response );

                return;
            }

            session.setAttribute("csrfToken", storedToken);

            session.setAttribute("game", game);

            session.setAttribute("gameId", gameId);

            BoardView boardView = new BoardView(game, storedToken);

            session.setAttribute("board", boardView);

            if (game.isGameStart())
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/playgame.jsp");

                dispatcher.forward( request, response );
            }
            else
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/setupgame.jsp");

                dispatcher.forward( request, response );
            }
        }
        else if (action.equals("add")) //request is used to add a piece
        {
            Game game;

            String gameId;

            try {
                gameId = (String) session.getAttribute("gameId");

                game = GameCache.getGame(gameId);
            }
            catch(IllegalArgumentException iae)
            {
                request.setAttribute( "message", iae );

                session.removeAttribute("gameId");

                session.removeAttribute("board");

                session.removeAttribute("game");

                session.setAttribute("csrfToken", storedToken);

                RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/html/userHome.jsp" );

                dispatcher.forward( request, response );

                return;
            }
            catch (ClassCastException cce)
            {
                request.setAttribute( "message", "No game available." );

                session.removeAttribute("gameId");

                session.removeAttribute("board");

                session.removeAttribute("game");

                session.setAttribute("csrfToken", storedToken);

                RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/html/userHome.jsp" );

                dispatcher.forward( request, response );

                return;
            }



            if (game==null)
            {
                request.setAttribute( "message", "game is stale" );

                session.removeAttribute("gameId");

                session.removeAttribute("board");

                session.removeAttribute("game");

                session.setAttribute("csrfToken", storedToken);

                RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/html/userHome.jsp" );

                dispatcher.forward( request, response );

                return;
            }


            String pieceType = request.getParameter("pieceType");

            String row = request.getParameter("row");

            String column = request.getParameter("column");

            if (row == null || column == null || pieceType ==null
                    || row.equals("") || column.equals("") || pieceType.equals(""))
            {
                //Not a meaningful request.

                session.setAttribute("csrfToken", storedToken);

                session.setAttribute("game", game);

                session.setAttribute("gameId", gameId);

                BoardView boardView = new BoardView(game, storedToken);

                session.setAttribute("board", boardView);

                if (game.isGameStart())
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/playgame.jsp");

                    dispatcher.forward( request, response );
                }
                else
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/setupgame.jsp");

                    dispatcher.forward( request, response );
                }

                return;
            }

            if (game.isGameStart())
            {
                //cannot add pieces during the game
                GameCache.addGame(gameId, game);

                session.setAttribute("csrfToken", storedToken);

                session.setAttribute("game", game);

                session.setAttribute("gameId", gameId);

                request.setAttribute("message", "Invalid Add");

                BoardView boardView = new BoardView(game, storedToken);

                session.setAttribute("board", boardView);

                if (game.isGameStart())
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/playgame.jsp");

                    dispatcher.forward( request, response );
                }
                else
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/setupgame.jsp");

                    dispatcher.forward( request, response );
                }
                return;
            }
            RegexHelper rx = new RegexHelper();
                if(rx.isMoveRegex(row) && rx.isMoveRegex(column)) {
                    try {
                        int r = Integer.valueOf(row);

                        int c = Integer.valueOf(column);

                        game.addPiece(r, c, pieceType, storedToken);
                    } catch (NumberFormatException nfe) {
                        GameCache.addGame(gameId, game);

                        session.setAttribute("csrfToken", storedToken);

                        session.setAttribute("game", game);

                        session.setAttribute("gameId", gameId);

                        request.setAttribute("message", "Invalid Add");

                        BoardView boardView = new BoardView(game, storedToken);

                        session.setAttribute("board", boardView);

                        if (game.isGameStart()) {
                            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/playgame.jsp");

                            dispatcher.forward(request, response);
                        } else {
                            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/setupgame.jsp");

                            dispatcher.forward(request, response);
                        }

                        return;
                    } catch (IllegalArgumentException iae) {
                        GameCache.addGame(gameId, game);

                        session.setAttribute("csrfToken", storedToken);

                        session.setAttribute("game", game);

                        session.setAttribute("gameId", gameId);

                        request.setAttribute("message", "Invalid Add");

                        BoardView boardView = new BoardView(game, storedToken);

                        session.setAttribute("board", boardView);

                        if (game.isGameStart()) {
                            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/playgame.jsp");

                            dispatcher.forward(request, response);
                        } else {
                            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/setupgame.jsp");

                            dispatcher.forward(request, response);
                        }

                        return;

                    }

                    GameCache.addGame(gameId, game);

                    session.setAttribute("csrfToken", storedToken);

                    session.setAttribute("game", game);

                    session.setAttribute("gameId", gameId);

                    BoardView boardView = new BoardView(game, storedToken);

                    session.setAttribute("board", boardView);

                    if (game.isGameStart()) {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/playgame.jsp");

                        dispatcher.forward(request, response);
                    } else {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/setupgame.jsp");

                        dispatcher.forward(request, response);
                    }
                }
                else{
                    log.warn("Move isn't legitmate");

                    session.setAttribute("csrfToken", storedToken);

                    session.setAttribute("game", game);

                    session.setAttribute("gameId", gameId);

                    request.setAttribute("message", "Invalid Add");

                    BoardView boardView = new BoardView(game, storedToken);

                    session.setAttribute("board", boardView);

                    if (game.isGameStart()) {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/playgame.jsp");

                        dispatcher.forward(request, response);
                    } else {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/setupgame.jsp");

                        dispatcher.forward(request, response);
                    }
                }
        }
        else if (action.equals("move")) //request is used to move a piece
        {

            Game game;

            String gameId;

            try {
                gameId = (String) session.getAttribute("gameId");

                game = GameCache.getGame(gameId);
            }
            catch (IllegalArgumentException iae)
            {
                //Thrown if the game id does not match an existing game
                //Return us to the home page because we don't have access to a game
                session.setAttribute("csrfToken", storedToken);

                session.removeAttribute("gameId");

                request.setAttribute("message", iae);

                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/userHome.jsp");

                dispatcher.forward(request, response);


                return;
            }
            catch (ClassCastException cce)
            {
                //Thrown if the game id is null or a non-String object
                //Return us to the home page because we don't have access to a game
                session.setAttribute("csrfToken", storedToken);

                session.removeAttribute("gameId");

                request.setAttribute("message", "Game not available.");

                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/userHome.jsp");

                dispatcher.forward(request, response);

                return;
            }


            if (game==null)
            {
                //Just in case an unexpected situation occurred
                //Return us back to the appropriate page without changing the game state
                session.setAttribute("csrfToken", storedToken);

                session.removeAttribute("gameId");

                request.setAttribute("message", "game is stale");

                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/userHome.jsp");

                dispatcher.forward(request, response);

                return;
            }
            RegexHelper rx = new RegexHelper();
            String fromRow = "";
            String fromColumn ="";
            String toRow ="";
            String toColumn ="";
            //Make sure move is 1-10
            if(rx.isMoveRegex(request.getParameter("fromRow")))
            fromRow = request.getParameter("fromRow");
            if(rx.isMoveRegex(request.getParameter("fromColumn")))
            fromColumn = request.getParameter("fromColumn");
            if(rx.isMoveRegex(request.getParameter("toRow")))
            toRow = request.getParameter("toRow");
            if(rx.isMoveRegex(request.getParameter("toColumn")))
            toColumn = request.getParameter("toColumn");

            if (fromRow == null || fromColumn == null || toRow == null || toColumn == null
                    || fromRow.equals("") || fromColumn.equals("") || toRow.equals("") || toColumn.equals(""))
            {
                //invalid request

                session.setAttribute("csrfToken", storedToken);

                session.setAttribute("game", game);

                session.setAttribute("gameId", gameId);

                BoardView boardView = new BoardView(game, storedToken);

                session.setAttribute("board", boardView);

                if (game.isGameStart())
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/playgame.jsp");

                    dispatcher.forward( request, response );
                }
                else
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/setupgame.jsp");

                    dispatcher.forward( request, response );
                }

                return;
            }

            if (!game.isGameStart()) {
                //cannot move pieces until game has started

                session.setAttribute("csrfToken", storedToken);

                session.setAttribute("game", game);

                session.setAttribute("gameId", gameId);

                BoardView boardView = new BoardView(game, storedToken);

                session.setAttribute("board", boardView);

                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/setupgame.jsp");

                dispatcher.forward( request, response );

                return;
            }

            int fr;
            int fc;
            int tr;
            int tc;

            try
            {
                fr = Integer.valueOf(fromRow);
                fc = Integer.valueOf(fromColumn);
                tr = Integer.valueOf(toRow);
                tc = Integer.valueOf(toColumn);
            }
            catch (NumberFormatException nfe)
            {
                //Thrown if the user sends ridiculously large values
                //return us to the appropriate page

                GameCache.addGame(gameId, game);

                session.setAttribute("csrfToken", storedToken);

                session.setAttribute("game", game);

                session.setAttribute("gameId", gameId);

                BoardView boardView = new BoardView(game, storedToken);

                session.setAttribute("board", boardView);

                request.setAttribute("message", "Invalid move.");

                if (game.isGameStart())
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/playgame.jsp");

                    dispatcher.forward( request, response );
                }
                else
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/setupgame.jsp");

                    dispatcher.forward( request, response );
                }

                return;
            }

            if (legitMove(fr, fc, tr, tc))
            {

                try {
                    game.move(fr, fc, tr, tc, storedToken);

                    UserDBConnection db = new UserDBConnection();

                    db.logMove(sessionUserName, gameId, "Move from " + fromRow + ":" + fromColumn + " to" + toRow + ":" + toColumn);
                } catch (IllegalArgumentException iae) {

                    GameCache.addGame(gameId, game);

                    session.setAttribute("csrfToken", storedToken);

                    session.setAttribute("game", game);

                    session.setAttribute("gameId", gameId);

                    BoardView boardView = new BoardView(game, storedToken);

                    session.setAttribute("board", boardView);

                    request.setAttribute("message", iae.getMessage());

                    if (game.isGameStart())
                    {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/playgame.jsp");

                        dispatcher.forward( request, response );
                    }
                    else
                    {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/setupgame.jsp");

                        dispatcher.forward( request, response );
                    }

                    return;
                }
                catch (IllegalStateException ise)
                {
                    GameCache.addGame(gameId, game);

                    session.setAttribute("csrfToken", storedToken);

                    session.setAttribute("game", game);

                    session.setAttribute("gameId", gameId);

                    BoardView boardView = new BoardView(game, storedToken);

                    session.setAttribute("board", boardView);

                    request.setAttribute("message", ise.getMessage());

                    if (game.isGameStart())
                    {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/playgame.jsp");

                        dispatcher.forward( request, response );
                    }
                    else
                    {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/setupgame.jsp");

                        dispatcher.forward( request, response );
                    }

                    return;
                }

                GameCache.addGame(gameId, game);

                session.setAttribute("csrfToken", storedToken);

                session.setAttribute("game", game);

                session.setAttribute("gameId", gameId);

                BoardView boardView = new BoardView(game, storedToken);

                session.setAttribute("board", boardView);

                if (game.isGameStart())
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/playgame.jsp");

                    dispatcher.forward( request, response );
                }
                else
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/setupgame.jsp");

                    dispatcher.forward( request, response );
                }
            }

            else{
                log.warn("Move is not legitimate");

                GameCache.addGame(gameId, game);

                session.setAttribute("csrfToken", storedToken);

                session.setAttribute("game", game);

                session.setAttribute("gameId", gameId);

                BoardView boardView = new BoardView(game, storedToken);

                session.setAttribute("board", boardView);

                request.setAttribute("message", "Move is invalid.");

                if (game.isGameStart())
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/playgame.jsp");

                    dispatcher.forward( request, response );
                }
                else
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/setupgame.jsp");

                    dispatcher.forward( request, response );
                }
            }
        }
    }

    private Boolean legitMove(int curRow, int curCol, int moveRow, int moveCol) {
    Boolean legit = false;

    if(curRow == moveRow){
        if((curCol == moveCol + 1) || (curCol == moveCol - 1)) {
            legit = true;
        }
    }
    else if(curCol == moveCol)
        {
            if((curRow == moveRow + 1) || (curRow == moveRow - 1)) {
                legit = true;
            }
        }
    else {
        legit = false;
    }
    return legit;
    }

    //need to finish writing out
    private void collision()
    {}


}
