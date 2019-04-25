package org.games.stratego.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DBConnection {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public DBConnection()
    {
        try
        {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/feedback?"
                            + "user=sqluser&password=sqluserpw");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

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
}
