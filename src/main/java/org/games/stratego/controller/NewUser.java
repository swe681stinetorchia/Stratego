package org.games.stratego.controller;

import org.games.stratego.Services.AntiCSRF;
import org.games.stratego.Services.SecureHash;
import org.games.stratego.Services.UserService;
import org.games.stratego.database.UserDBConnection;
import org.games.stratego.model.admin.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class NewUser extends HttpServlet {

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        System.out.println( "doGet" );

        // Create a session
        HttpSession session = request.getSession();
        session.setAttribute( "loggedIn", "false" );
        RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/html/newUser.jsp" );
        dispatcher.forward( request, response );
    }

    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        System.out.println("doPost");

        HttpSession session = request.getSession();
        if (session.isNew()) {
            // A session should already exist--something's wrong
            System.out.println("New session error");
            invalidAccess(response);
            return;
        }

        String param = (String) request.getParameter("newUser");
        if (param != null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            UserService userService = UserService.getInstance();

            userService.addUser(username, password);


            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/html/login.jsp");
            dispatcher.forward(request, response);
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
