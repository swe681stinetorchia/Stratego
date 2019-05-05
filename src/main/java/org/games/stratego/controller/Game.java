package org.games.stratego.controller;

import  org.games.stratego.Services.RegexHelper;
import org.games.stratego.database.BoardDBConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Game extends HttpServlet
{
    //in your servlet or other web request handling code

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String storedToken = (String) session.getAttribute("csrfToken");
        String token = request.getParameter("token");
        String input = request.getParameter("move");
        RegexHelper rh = new RegexHelper();
        int curRow = 0;
        int curCol = 0;
        int moveRow = 0;
        int moveCol = 0;
        String cur_piece = "";
        String move_piece = "";
        if (rh.isMoveRegex(input)) {
            //do check
            if (storedToken.equals(token)) {
                //go ahead and process ... do business logic here
                curRow = Integer.parseInt(input.substring(0, 1));
                curCol = Integer.parseInt(input.substring(2, 3));
                moveRow = Integer.parseInt(input.substring(0, 1));
                moveCol = Integer.parseInt(input.substring(2, 3));
                cur_piece = "position_" + curRow + "_" + curCol;
                //is Piece owner
                if (true) {
                    //is legitimate move
                    if (legitMove(curRow, curCol, moveRow, moveCol)) {
                        System.out.println("Outstanding Move!");
                        move_piece = "position_" + curRow + "_" + curCol;
                        
                    } else {
                        System.out.println("Choose a legitimate move silly!");
                    }
                }
             else {
                System.out.println("Choose a piece that you own silly!");
            }
        } else {
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
        RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/html/game.jsp" );
        getBoard(request);
        dispatcher.forward( request, response );
    }

    public Boolean legitMove(int curRow, int curCol, int moveRow, int moveCol) {
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

    public void getBoard(HttpServletRequest request) throws MalformedURLException {
        String col_name;
        String piece_id;
        String id_name;
        String piece_name;
        String src = "";
        String gameID= "97f2c246-6e87-11e9-b4e5-025041000001";
        for (int row = 1; row < 11; row++) {
            for (int col = 1; col < 11; col++) {
                col_name = "position_" + row + "_" + col;
                id_name = "sq" + row + col;
                //Need to bring in game_id
                BoardDBConnection db = new BoardDBConnection();
                //piece_id = db.getPiece(col_name, gameID);
                piece_id = "4bb3493d-6e8b-11e9-b4e5-025041000001";
                ServletContext context = getServletContext(); // Inherited from HttpServlet.
                //check if the piece is the owner
                //if(db.getOwner())
                if (true) {
                    piece_name = db.getPieceRank(piece_id);
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
    }


}

/**@RestController
@RequestMapping(value="game")
public class GameController{

    @CrossOrigin
    @RequestMapping(value="testOne", method = RequestMethod.GET)
    public String testOne() throws JSONException {

        return "One";
    }

    @CrossOrigin
    @RequestMapping(value="testTwo", method = RequestMethod.GET)
    public String testTwo() throws JSONException {

        return "Two";
    }

    @CrossOrigin
    @RequestMapping(value="/testThree/{param}", method = RequestMethod.GET)
    public String testThree(@PathVariable("param") String parameter) throws JSONException {

        return "Here is the parameter you sent: " + parameter;
    }

    @CrossOrigin
    @RequestMapping(value="/testDB/{param}", method = RequestMethod.GET)
    public String testDB(@PathVariable("param") String parameter) throws JSONException {

        DBConnection dbConnection = new DBConnection(false);
        return "Here is the DB parameter you sent: " + parameter;
    }

    @CrossOrigin
    @RequestMapping(value="/testDBTwo/{param}", method = RequestMethod.GET)
    public String testDBTwo(@PathVariable("param") String parameter) throws JSONException {

        DBConnection dbConnection = new DBConnection(true);
        return "Two: Here is the DB parameter you sent: " + parameter;
    }

    @CrossOrigin
    @RequestMapping(value="/testDBThree/{param}", method = RequestMethod.GET)
    public String testDBThree(@PathVariable("param") String parameter) throws JSONException {

        DBConnection dbConnection = new DBConnection(true);
        String custRet = dbConnection.getCustomers();
        return custRet + "\nTwo: Here is the DB parameter you sent: " + parameter;
    }





}**/
