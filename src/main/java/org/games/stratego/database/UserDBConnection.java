package org.games.stratego.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.games.stratego.Services.SecureHash;
import org.games.stratego.Services.StrategoGetPropertyValues;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDBConnection extends StrategoDBConnection {

    protected Connection connect = null;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;
    protected final Logger log = LogManager.getLogger(getClass());
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
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
    }

    public void addUser(String user, String pass)
    {

        try {
            connect = DriverManager
                    .getConnection(url, username, password);

            log.debug("1 adding " + user + " : " + pass);

            preparedStatement = connect
                    .prepareStatement("insert into stratego.users values(UUID(), ?, ?, TRUE, SYSDATE())");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            int result = preparedStatement.executeUpdate();

            if (result!=1)
            {
                log.debug("failed insert");
            }
            connect.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            log.fatal(e.getMessage());
        }
    }
    public Boolean isActiveUser(String userID)
    {
        Boolean isActive = false;
        try {
            connect = DriverManager
                    .getConnection(url, username, password);

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
            connect = DriverManager
                    .getConnection(url, username, password);

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
            connect = DriverManager
                    .getConnection(url, username, password);

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

    public void setSessionID(String sessionID, String user, String pass)
    {
        try {
            connect = DriverManager
                    .getConnection(url, username, password);

            preparedStatement = connect
                    .prepareStatement("update stratego.users set session_id = ? WHERE username = ? and password = ?");
            preparedStatement.setString(1, sessionID);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);

            int result = preparedStatement.executeUpdate();

            if (result!=1)
            {
                log.debug("failed update");
            }

            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
    }

    public boolean checkPassword(String user, String pass)
    {
        try {
            connect = DriverManager
                    .getConnection(url, username, password);

            preparedStatement = connect
                    .prepareStatement("select password from stratego.users WHERE username = ?");
            preparedStatement.setString(1, user);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
            {
                String stored = resultSet.getString(1);
                connect.close();

                System.out.println("Check " + pass + " against " + stored);
                return SecureHash.validatePassword(pass, stored);
            }
            connect.close();
            return false;
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
            return false;
        }
        catch (NoSuchAlgorithmException nsae)
        {
            log.fatal(nsae.getMessage());
            return false;
        }
        catch (InvalidKeySpecException ikse)
        {
            log.fatal(ikse.getMessage());
            return false;
        }
    }
}
