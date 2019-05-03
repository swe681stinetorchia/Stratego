package org.games.stratego.database;

import org.apache.log4j.Logger;
import org.games.stratego.Services.StrategoGetPropertyValues;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDBConnection extends StrategoDBConnection {

    protected Connection connect = null;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;
    protected final Logger log = Logger.getLogger(getClass());
    protected String url;
    protected String username;
    protected String password;

    public UserDBConnection() {
        try {
            StrategoGetPropertyValues config = new StrategoGetPropertyValues();
            url = config.getPropValues("dbURL");
            username = config.getPropValues("username");
            password = config.getPropValues("password");
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
    }

    public void addUser(String username, String password)
    {

        try {
            connect = DriverManager
                    .getConnection(url, username, password);

            preparedStatement = connect
                    .prepareStatement("insert into stratego.users (UUID(), ?, ?, TRUE, SYSDATE())");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
    }
    public Boolean isActiveUser(String userID)
    {
        Boolean isActive = false;
        try {
            preparedStatement = connect
                    .prepareStatement("select isActive from stratego.users WHERE id = ?");
            preparedStatement.setString(1, userID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                isActive = Boolean.parseBoolean(resultSet.getString("isActive"));
            }
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return isActive;
    }

    public List getActiveUsers()
    {
        List<String> users =  new ArrayList<String>();
        try {
            preparedStatement = connect
                    .prepareStatement("select username from stratego.users WHERE isActive = TRUE");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                users.add(resultSet.getString("username"));
            }
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return users;
    }

    public String getID(String sessionID)
    {
        String user ="";
        try {
            preparedStatement = connect
                    .prepareStatement("select id from stratego.users WHERE session_id = ?");
            preparedStatement.setString(1, sessionID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
               user = resultSet.getString("id");
            }
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return user;
    }

    public void setSessionID(String sessionID, String username, String password)
    {
        try {
            preparedStatement = connect
                    .prepareStatement("update stratego.users set session_id = ? WHERE username = ? and password = ?");
            preparedStatement.setString(1, sessionID);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.executeQuery();
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
    }

    public boolean checkPassword(String username, String password)
    {
        try {
            preparedStatement = connect
                    .prepareStatement("select * from stratego.users WHERE username = ? and password = ?");
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next())
            {
                return false;
            }
            connect.close();
            return true;
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
    }
}
