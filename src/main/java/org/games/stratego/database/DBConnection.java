package org.games.stratego.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DBConnection {

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    private final String URL= "jdbc:mysql://127.0.0.1:3306/classicmodels?useSSL=false";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "g3ntlemenST@Rty0ur$nTine$";

    private static DBConnection dbConn = new DBConnection();

    private DBConnection()
    {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.out.println("JAVA: Class.forName() error");
            e.printStackTrace();
        }
        try {

            connection = DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error in initializing a connection to MYSQL DB");
            e.printStackTrace();

        }
    }

    public static DBConnection getInstance() { return dbConn;}

    public Connection getConnection()
    {
        return connection;
    }


    /**
    public String getUsers()
    {
        String returnVal = "";
        try
        {
            preparedStatement = connect
                    .prepareStatement("select * from User");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                returnVal = resultSet.getString(2);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return returnVal;
    }

    public String getCustomers()
    {
        String returnVal = "";
        try
        {
            preparedStatement = connect
                    .prepareStatement("select * from customers");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                returnVal = resultSet.getString(2);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return returnVal;
    }**/
}
