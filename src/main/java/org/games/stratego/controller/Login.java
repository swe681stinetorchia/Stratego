package org.games.stratego.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.games.stratego.Services.AntiCSRF;
import java.io.IOException;
import java.io.PrintWriter;

import org.games.stratego.Services.UserService;

public class Login extends HttpServlet {

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response )
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
            throws ServletException, IOException
    {
        System.out.println( "doPost" );

        HttpSession session = request.getSession();
        if( session.isNew() )
        {
            // A session should already exist--something's wrong
            System.out.println( "New session error" );
            invalidAccess( response );
            return;
        }

        String param = (String) request.getParameter( "loginSubmit" );
        if( param != null )
        {
            if( UserService.getInstance().validate( (String) request.getParameter( "username" ),
                    (String) request.getParameter( "password" )))
            {
                System.out.println( "validation success -- dispatch sf86-Part1" );

                session.setAttribute( "loggedIn", "true" );
                //in authentication function
                session.setAttribute("csrfToken", AntiCSRF.generateCSRFToken());
                RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/html/sf86-Part1.jsp" );
                dispatcher.forward( request, response );
                return;
            }
            else
            {
                System.out.println( "validation failed" );

                session.setAttribute( "loggedIn", "false" );

                Integer attempts = (Integer) session.getAttribute( "loginAttempts" );
                session.setAttribute( "loginAttempts",
                        new Integer( attempts == null ? 1 : attempts.intValue() + 1 ));

                RequestDispatcher dispatcher = request.getRequestDispatcher( "html/loginError.jsp" );
                dispatcher.forward( request, response );
                return;
            }
        }

        boolean loggedIn = Boolean.getBoolean( (String) session.getAttribute( "loggedIn" ));
        if( loggedIn )
        {
            param = (String) request.getParameter( "savePart1" );
            if( param != null )
            {
                System.out.println( "Save Part 1" );

                return;
            }

            param = (String) request.getParameter( "continuePart1" );
            if( param != null )
            {
                System.out.println( "Save Part 1 and Continue" );

                return;
            }
        }
        else
        {
            System.out.println( "Not logged in error" );
            invalidAccess( response );
        }
    }

    @Override
    public void destroy()
    {
        // Finalization code...
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
