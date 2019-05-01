package org.games.stratego.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BoardDAO {

    private static final String SQUARE_OCCUPIED_QUERY =
            "select ID, C_CODE, C_NAME, C_ORDER from T_SERIOUSNESS ORDER BY C_ORDER";

    private Connection connect = null;
    private final String URL= "jdbc:mysql://127.0.0.1:3306/classicmodels?useSSL=false";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "g3ntlemenST@Rty0ur$nTine$";

    public BoardDAO()
    {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.out.println("JAVA: Class.forName() error");
            e.printStackTrace();
        }
        try {

            connect = DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error in initializing a connection to MYSQL DB");
            e.printStackTrace();

        }
    }


    public void disconnect()
    {
        try
        {
            connect.close();
        }
        catch(SQLException sqe)
        {
            sqe.printStackTrace();
        }
    }
}
