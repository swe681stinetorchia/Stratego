package org.games.stratego.controller;

import java.io.IOException;
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
