package org.games.stratego.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.games.stratego.Services.AntiCSRF;
import org.games.stratego.model.admin.Session;

import java.io.IOException;
import java.io.PrintWriter;

import static javax.swing.text.html.CSS.getAttribute;

public class TestLogin extends HttpServlet {

    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        System.out.println("doPost");

        HttpSession session = request.getSession();

        String token = (String) session.getAttribute("csrfToken");

        String username = Session.checkSession(token);

    }
}
