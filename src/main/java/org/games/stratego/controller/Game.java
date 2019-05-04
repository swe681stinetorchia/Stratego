package org.games.stratego.controller;

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


//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.CrossOrigin;



public class Game extends HttpServlet
{
    //in your servlet or other web request handling code

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String storedToken = (String)session.getAttribute("csrfToken");
        String token = request.getParameter("token");
        //do check
        if (storedToken.equals(token)) {
            //go ahead and process ... do business logic here


        } else {
            //DO NOT PROCESS ... this is to be considered a CSRF attack - handle appropriately
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
                //Need to bring in game_id
                BoardDBConnection db = new BoardDBConnection();
                //piece_id = db.getPiece(col_name, gameID);
                piece_id = "4bb3493d-6e8b-11e9-b4e5-025041000001";
                piece_name = db.getPieceRank(piece_id);
                id_name = "sq" + row + col;
                ServletContext context = getServletContext(); // Inherited from HttpServlet.
                String picture = "";
                if(piece_name.equals("Flag")){
                    picture = context.getRealPath("/html/images/flag.PNG");
                    //src = context.getResource("/html/images/flag.PNG").getPath();
                }

                request.setAttribute(id_name, picture);
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
