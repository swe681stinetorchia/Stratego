package org.games.stratego.database;

import org.apache.log4j.Logger;
import org.games.stratego.Services.StrategoGetPropertyValues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class StrategoDBConnection {

    protected static Connection connect = null;
    protected static Statement statement = null;
    protected static PreparedStatement preparedStatement = null;
    protected static ResultSet resultSet = null;
    protected final Logger log = Logger.getLogger(getClass());
    protected String url;
    protected String username;
    protected String password;

    public StrategoDBConnection() {
        try {
            url = StrategoGetPropertyValues.getPropValues("dbURL");
            username = StrategoGetPropertyValues.getPropValues("username");
            password = StrategoGetPropertyValues.getPropValues("password");
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
    }

    public String getPiece(String col_name, String game_id)
    {
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
            log.fatal(e.getMessage());
        }
        return returnVal;
    }



}
