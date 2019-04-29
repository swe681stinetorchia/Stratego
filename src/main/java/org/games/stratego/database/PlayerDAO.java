package org.games.stratego.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlayerDAO {

    private Connection connect = null;
    private final String URL= "jdbc:mysql://127.0.0.1:3306/classicmodels?useSSL=false";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "g3ntlemenST@Rty0ur$nTine$";

    public PlayerDAO()
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
}
