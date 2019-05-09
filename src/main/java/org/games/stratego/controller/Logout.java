package org.games.stratego.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/Logout")
public class Logout extends HttpServlet {
    private final Logger log = LogManager.getLogger(getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        doGet(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        /*
         * First step : Invalidate user session
         */
        HttpSession session = request.getSession(false);
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

    }

}
