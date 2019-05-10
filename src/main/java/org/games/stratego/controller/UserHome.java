package org.games.stratego.controller;

import org.games.stratego.database.UserDBConnection;
import org.games.stratego.model.admin.Sessions;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserHome extends HttpServlet {

    private final Logger log = LogManager.getLogger(getClass());

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {

        String storedToken = "";
        HttpSession session = request.getSession(false);
        RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/html/userHome.jsp" );

        //go ahead and process ... do business logic here
        String sessionUserName = Sessions.checkSession(storedToken);

        if (sessionUserName==null)
        {
            //session token is stale or invalid
            session.setAttribute( "loggedIn", "false" );
            log.error("Session token is stale or invalid");
            dispatcher = request.getRequestDispatcher( "WEB-INF/html/loginError.jsp" );

        }

        UserDBConnection db = new UserDBConnection();
        List<String> moveHistory = db.getMoves(sessionUserName);
        request.setAttribute("moveHistory", moveHistory);
        dispatcher.forward( request, response );
    }
}
