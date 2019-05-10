package org.games.stratego.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.games.stratego.Services.AntiCSRF;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.games.stratego.Services.RegexHelper;
import org.games.stratego.Services.UserService;
import org.games.stratego.model.admin.DashboardView;
import org.games.stratego.model.admin.GameCache;
import org.games.stratego.model.admin.Sessions;
import org.games.stratego.model.gameplay.Game;

public class Login extends HttpServlet {
    private final Logger log = LogManager.getLogger(getClass());

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        System.out.println("doGet");

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
            log.error("Please enter alpha numeric for username");
            System.out.println( "New session error" );
            invalidAccess( response );
            return;
        }

        String param = request.getParameter( "loginSubmit" );
        if( param != null )
        {
            RegexHelper rx = new RegexHelper();
            if(rx.isAlphaNumericRegex(request.getParameter("username"))) {
                if (UserService.getInstance().validate(request.getParameter("username"),
                        request.getParameter("password"))) {

                    session.setAttribute("loggedIn", "true");

                    String username = request.getParameter("username");

                    String sessionToken = AntiCSRF.generateCSRFToken();

                    Sessions.addSession(sessionToken, username);

                    Map<String, Game> assignedGames = GameCache.getAssignedGames(username);

                    System.out.println("Assigned games: " + assignedGames.size());

                    DashboardView view = new DashboardView(username, assignedGames);

                    System.out.println("Ongoing games: " + view.getOngoingGames().size());

                    request.setAttribute("assigned", assignedGames);

                    request.setAttribute("view", view);

                    session.setAttribute("csrfToken", sessionToken);

                    session.setAttribute("username", username);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/html/userHome.jsp");

                    dispatcher.forward(request, response);
                } else {

                    log.warn("validation failed");

                    System.out.println("validation failed");

                    session.setAttribute("loggedIn", "false");

                    Integer attempts = (Integer) session.getAttribute("loginAttempts");

                    session.setAttribute("loginAttempts",
                            new Integer(attempts == null ? 1 : attempts.intValue() + 1));
                    log.warn("Login attempts:" + attempts);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/loginError.jsp");

                    dispatcher.forward(request, response);
                }
            }
            else
                {
                log.warn("Please enter alpha numeric for username");
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/loginError.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    /*
    @Override
    public void destroy()
    {
        // Finalization code...
    }**/


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
