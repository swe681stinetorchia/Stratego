package org.games.stratego.controller;

import org.games.stratego.Services.UserService;
import org.games.stratego.database.UserDBConnection;
import org.games.stratego.Services.RegexHelper;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class NewUser extends HttpServlet {

    private final Logger log = LogManager.getLogger(getClass());
    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        // Create a session
        HttpSession session = request.getSession();
        session.setAttribute( "loggedIn", "false" );
        RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/html/newUser.jsp" );
        dispatcher.forward( request, response );
    }

    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        if (session.isNew()) {
            // A session should already exist--something's wrong
            log.error("New session error");
            invalidAccess(response);
            return;
        }

        String param = request.getParameter("newUser");
        if (param != null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDBConnection db = new UserDBConnection();
            RegexHelper rx = new RegexHelper();
            if(rx.isAlphaNumericRegex(username))
            {
                if (username.equals(db.validateUserName(username)))
                {
                    log.warn("Username already taken");
                }
                else {
                    UserService userService = UserService.getInstance();
                    userService.addUser(username, password);
                    log.info("Username created");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/html/login.jsp");
                    dispatcher.forward(request, response);
                }
                }
            else {
                log.warn("Please enter alpha numeric for username");
            }
        }
    }


    private void invalidAccess( HttpServletResponse response )  throws IOException
    {
        PrintWriter writer = response.getWriter();
        try
        {
            response.setContentType( "text/html" );
            writer.println( "<html><h1>Invalid Access</h1></html>" );
        }
        finally
        {
            writer.close();
        }

    }
}
