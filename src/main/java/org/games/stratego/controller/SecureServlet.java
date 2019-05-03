package org.games.stratego.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecureServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        System.out.println( "doGet" );

        // Create a session
        HttpSession session = request.getSession();
        session.setAttribute( "loggedIn", "false" );
        RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/html/login.jsp" );
        dispatcher.forward( request, response );
    }

    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

    }
}
