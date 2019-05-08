package org.games.stratego.controller;

import org.games.stratego.database.UserDBConnection;
import org.games.stratego.model.admin.Sessions;
import org.games.stratego.model.gameplay2.Player;
import org.games.stratego.database.UserDBConnection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserHome extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {

        String storedToken = "";
        HttpSession session = request.getSession(false);
        System.out.println( "doGet" );
        RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/html/userHome.jsp" );

        String token = request.getParameter("token");

        //go ahead and process ... do business logic here
        String sessionUserName = Sessions.checkSession(storedToken);

        if (sessionUserName==null)
        {
            //session token is stale or invalid
            session.setAttribute( "loggedIn", "false" );

            dispatcher = request.getRequestDispatcher( "WEB-INF/html/loginError.jsp" );

            dispatcher.forward( request, response );

            return;
        }

        UserDBConnection db = new UserDBConnection();
        //List<String> listPlayers = db.getOpponent(sessionUserName);
        //request.setAttribute("listPlayers", listPlayers);
        dispatcher.forward( request, response );
    }

    /*
    //sudo code
    public void startDefaultGame(String player_one, String player_two)
    {


    }

    public String[][] setDefaultBoard()
    {
        String[][] board = new String[10][10];
        board [0][0] = "B";
        board [0][1] = "F";
        board [0][2] = "B";
        board [0][3] = "5";
        board [0][4] = "6";
        board [0][5] = "7";
        board [0][6] = "7";
        board [0][7] = "9";
        board [0][8] = "9";
        board [0][9] = "8";
        board [1][0] = "7";
        board [1][1] = "B";
        board [1][2] = "4";
        board [1][3] = "8";
        board [1][4] = "6";
        board [1][5] = "4";
        board [1][6] = "3";
        board [1][7] = "8";
        board [1][8] = "7";
        board [1][9] = "6";
        board [2][0] = "B";
        board [2][1] = "7";
        board [2][2] = "9";
        board [2][3] = "1";
        board [2][4] = "4";
        board [2][5] = "5";
        board [2][6] = "8";
        board [2][7] = "5";
        board [2][8] = "3";
        board [2][9] = "9";
        board [3][0] = "7";
        board [3][1] = "B";
        board [3][2] = "5";
        board [3][3] = "2";
        board [3][4] = "9";
        board [3][5] = "9";
        board [3][6] = "1";
        board [3][7] = "8";
        board [3][8] = "9";
        board [3][9] = "B";
        board [4][0] = "x";
        board [4][1] = "x";
        board [4][2] = "x";
        board [4][3] = "x";
        board [4][4] = "x";
        board [4][5] = "x";
        board [4][6] = "x";
        board [4][7] = "x";
        board [4][8] = "x";
        board [4][9] = "x";
        board [5][0] = "x";
        board [5][1] = "x";
        board [5][2] = "x";
        board [5][3] = "x";
        board [5][4] = "x";
        board [5][5] = "x";
        board [5][6] = "x";
        board [5][7] = "x";
        board [5][8] = "x";
        board [5][9] = "x";
        board [6][0] = "7";
        board [6][1] = "B";
        board [6][2] = "5";
        board [6][3] = "2";
        board [6][4] = "9";
        board [6][5] = "9";
        board [6][6] = "1";
        board [6][7] = "8";
        board [6][8] = "9";
        board [6][9] = "B";
        board [7][0] = "B";
        board [7][1] = "7";
        board [7][2] = "9";
        board [7][3] = "1";
        board [7][4] = "4";
        board [7][5] = "5";
        board [7][6] = "8";
        board [7][7] = "5";
        board [7][8] = "3";
        board [7][9] = "9";
        board [8][0] = "7";
        board [8][1] = "B";
        board [8][2] = "4";
        board [8][3] = "8";
        board [8][4] = "6";
        board [8][5] = "4";
        board [8][6] = "3";
        board [8][7] = "8";
        board [8][8] = "7";
        board [8][9] = "6";
        board [9][0] = "B";
        board [9][1] = "F";
        board [9][2] = "B";
        board [9][3] = "5";
        board [9][4] = "9";
        board [9][5] = "6";
        board [9][6] = "6";
        board [9][7] = "9";
        board [9][8] = "9";
        board [9][9] = "8";

        return board;
    }*/
}
