package org.games.stratego.controller;

import org.games.stratego.Services.RegexHelper;
import org.games.stratego.database.BoardDBConnection;
import org.games.stratego.model.admin.Sessions;
import org.games.stratego.model.admin.User;
import org.games.stratego.model.gameplay2.Game;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GameServlet extends HttpServlet {
    //in your servlet or other web request handling code

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String storedToken;

        try {
            storedToken = (String) session.getAttribute("csrfToken");
        }
        catch (ClassCastException cce)
        {
            session.setAttribute( "loggedIn", "false" );

            RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB_INF/html/loginError.jsp" );

            dispatcher.forward( request, response );

            return;
        }

            String token = request.getParameter("token");

        //do check
        if (storedToken.equals(token)) {

            //go ahead and process ... do business logic here
            String sessionUserName = Sessions.checkSession(storedToken);

            if (sessionUserName==null)
            {
                //session token is stale or invalid
                session.setAttribute( "loggedIn", "false" );

                RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB_INF/html/loginError.jsp" );

                dispatcher.forward( request, response );

                return;
            }

            User userOne = new User(sessionUserName);

            String userTwoName = request.getParameter("opponent");

            User userTwo = new User(userTwoName);

            Game game = new Game(userOne, userTwo);

            session.setAttribute("csrfToken", storedToken);

            session.setAttribute("game", game);

            RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB_INF/html/game.jsp" );

            dispatcher.forward( request, response );

        } else {
            //DO NOT PROCESS ... this is to be considered a CSRF attack - handle appropriately
            session.setAttribute( "loggedIn", "false" );

            RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB_INF/html/loginError.jsp" );

            dispatcher.forward( request, response );
        }
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BoardDBConnection db = new BoardDBConnection();

        HttpSession session = request.getSession();

        String storedToken;

        try {
            storedToken = (String) session.getAttribute("csrfToken");
        }
        catch (ClassCastException cce)
        {
            session.setAttribute( "loggedIn", "false" );

            RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB_INF/html/loginError.jsp" );

            dispatcher.forward( request, response );

            return;
        }

        String token = request.getParameter("token");
        String input = request.getParameter("move");
        RegexHelper rh = new RegexHelper();
        int curRow = 0;
        int curCol = 0;
        int moveRow = 0;
        int moveCol = 0;
        String cur_piece = "";
        String move_piece = "";
        String cur_piece_name = "";
        String move_piece_name = "";
        if (rh.isMoveRegex(input)) {
            //do check
            if (storedToken.equals(token)) {
                //go ahead and process ... do business logic here
                curRow = Integer.parseInt(input.substring(0, 1));
                curCol = Integer.parseInt(input.substring(2, 3));
                moveRow = Integer.parseInt(input.substring(0, 1));
                moveCol = Integer.parseInt(input.substring(2, 3));
                cur_piece = "position_" + curRow + "_" + curCol;
                cur_piece_name = db.getPieceRank(Integer.parseInt(cur_piece));
                //Bomb and Flag cant move!
                if (!(cur_piece_name.equals("Flag") || cur_piece_name.equals("Bomb"))) {
                    //is Piece owner
                    if (true) {
                        //is legitimate move
                        if (legitMove(curRow, curCol, moveRow, moveCol)) {
                            System.out.println("Outstanding Move!");
                            collision();
                        } else {
                            System.out.println("Choose a legitimate move silly!");
                        }
                    } else {
                        System.out.println("Choose a piece that you own silly!");
                    }
                }
                    else {
                    System.out.println("Bomb and Flag Cannot move");
                }
            }
         else {
            //DO NOT PROCESS ... this is to be considered a CSRF attack - handle appropriately
            System.out.println("CSRF Check Failed");
        }
    }

        else
        {
            System.out.println( "Regex Check failed" );
        }
    }

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {

        HttpSession session = request.getSession();

        int gameId = Integer.valueOf(request.getParameter("gameId"));

        String storedToken;

        try {
            storedToken = (String) session.getAttribute("csrfToken");
        }
        catch (ClassCastException cce)
        {
            session.setAttribute( "loggedIn", "false" );

            RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB_INF/html/loginError.jsp" );

            dispatcher.forward( request, response );

            return;
        }

        String sessionUserName = Sessions.checkSession(storedToken);

        if (sessionUserName==null)
        {
            //session token is stale or invalid
            session.setAttribute( "loggedIn", "false" );

            RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB_INF/html/loginError.jsp" );

            dispatcher.forward( request, response );

            return;
        }

        Game game = new Game(gameId);

        session.setAttribute("csrfToken", storedToken);

        session.setAttribute("game", game);

        RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB_INF/html/game.jsp" );

        dispatcher.forward( request, response );
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

    /*
    public void getBoard(HttpServletRequest request) throws MalformedURLException {
        String col_name;
        String piece_id;
        String id_name;
        String piece_name;
        String src = "";
        String token = (String) request.getAttribute("csrfToken");
        String gameID= "97f2c246-6e87-11e9-b4e5-025041000001";
        for (int row = 1; row < 11; row++) {
            for (int col = 1; col < 11; col++) {
                col_name = "position_" + row + "_" + col;
                id_name = "sq" + row + col;
                //Need to bring in game_id
                BoardDBConnection db = new BoardDBConnection();
                piece_id = db.getPiece(col_name, gameID);
                ServletContext context = getServletContext(); // Inherited from HttpServlet.
                //check if the piece is the owner
                //if(db.getOwner())
                if (true) {
                    piece_name = db.getPieceRank(Integer.parseInt(piece_id));
                    String picture = "";
                    if (piece_name.equals("Flag")) {
                        //picture = context.getRealPath("/html/images/flag.PNG");
                        src = context.getResource("/html/images/flag.PNG").getPath();
                    } else if (piece_name.equals("Bomb")) {
                        //picture = context.getRealPath("/html/images/flag.PNG");
                        src = context.getResource("/html/images/bomb.PNG").getPath();
                    }
                    if (piece_name.equals("Marshall")) {
                        //picture = context.getRealPath("/html/images/flag.PNG");
                        src = context.getResource("/html/images/marshall.PNG").getPath();
                    } else if (piece_name.equals("General")) {
                        //picture = context.getRealPath("/html/images/flag.PNG");
                        src = context.getResource("/html/images/general.PNG").getPath();
                    } else if (piece_name.equals("Major")) {
                        //picture = context.getRealPath("/html/images/flag.PNG");
                        src = context.getResource("/html/images/major.PNG").getPath();
                    } else if (piece_name.equals("Captain")) {
                        //picture = context.getRealPath("/html/images/flag.PNG");
                        src = context.getResource("/html/images/captain.PNG").getPath();
                    } else if (piece_name.equals("Lieutenant")) {
                        //picture = context.getRealPath("/html/images/flag.PNG");
                        src = context.getResource("/html/images/lieutenant.PNG").getPath();
                    } else if (piece_name.equals("Sergeant")) {
                        //picture = context.getRealPath("/html/images/flag.PNG");
                        src = context.getResource("/html/images/sergeant.PNG").getPath();
                    } else if (piece_name.equals("Miner")) {
                        //picture = context.getRealPath("/html/images/flag.PNG");
                        src = context.getResource("/html/images/miner.PNG").getPath();
                    } else if (piece_name.equals("Scout")) {
                        //picture = context.getRealPath("/html/images/flag.PNG");
                        src = context.getResource("/html/images/scout.PNG").getPath();
                    } else if (piece_name.equals("Spy")) {
                        //picture = context.getRealPath("/html/images/flag.PNG");
                        src = context.getResource("/html/images/spy.PNG").getPath();
                    } else
                        src = context.getResource("/html/images/blank.PNG").getPath();
                }
                else
                    //opponents piece
                src = context.getResource("/html/images/mystery.PNG").getPath();
                request.setAttribute(id_name, src);
            }
        }
    }**/


}
