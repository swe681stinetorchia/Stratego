package org.games.stratego.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class StrategoDBConnection {

    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public StrategoDBConnection() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/stratego?useSSL=false"
                            , "root", "francis");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPiece(String col_name, String game_id)
    {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/stratego?useSSL=false"
                            , "root", "francis");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String returnVal = "";

        try {
            preparedStatement = connect
                    .prepareStatement("select ? from board where game_id=?");
            preparedStatement.setString(1, col_name);
            preparedStatement.setString(2, game_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                returnVal = resultSet.getString(2);
                System.out.println(returnVal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnVal;
    }



}
