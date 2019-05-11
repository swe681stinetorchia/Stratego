package org.games.stratego.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.games.stratego.model.admin.GameCache;
import org.games.stratego.model.gameplay.Game;

import java.io.IOException;


public class Logout extends HttpServlet {
    private final Logger log = LogManager.getLogger(getClass());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * First step : Invalidate user session
         */
        HttpSession session = request.getSession(false);

        if (session.getAttribute("gameId")!=null)
        {
            Game game;
            try
            {
                String gameId = (String) session.getAttribute("gameId");

                game = GameCache.getGame(gameId);

                try
                {
                    String token = (String) session.getAttribute("csrfToken");

                    game.surrender(token);

                    GameCache.addGame(gameId, game);
                }
                catch (ClassCastException cce)
                {
                    log.warn("session token attribute is not a String");
                }
            }
            catch (ClassCastException cce)
            {
                log.warn("gameId attribute is not a String");
            }
        }

        if (session != null) {
            session.invalidate();
        }
        log.info("User Logged out");
        /*
         * Second step : Invalidate all cookies by, for each cookie received,
         * overwriting value and instructing browser to deletes it
         */
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                cookie.setValue("-");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/logout.jsp");

        dispatcher.forward(request, response);

    }

}
