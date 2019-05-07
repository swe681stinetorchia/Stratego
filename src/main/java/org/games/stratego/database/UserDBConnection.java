package org.games.stratego.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.games.stratego.Services.SecureHash;
import org.games.stratego.Services.StrategoGetPropertyValues;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;

public class UserDBConnection {

    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private final Logger log = LogManager.getLogger(getClass());
    private String url;
    private String username;
    private String password;

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


    public int addUser(String user, String pass)
    {

        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);
            preparedStatement = connect
                    .prepareStatement("insert into stratego.users (username, password, isActive, dateAdded) values(?, ?, TRUE, SYSDATE())");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            int result = preparedStatement.executeUpdate();

            if (result!=1)
            {
                log.debug("failed insert");
            }

            PreparedStatement lastIdStat = connect.prepareCall("SELECT LAST_INSERT_ID()");

            ResultSet idResSet = lastIdStat.executeQuery();

            connect.close();

            if(idResSet.next())
            {
                return idResSet.getInt(0);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            log.fatal(e.getMessage());
        }
        return -1;
    }

    /*
    public Boolean isActiveUser(int userID)
    {
        Boolean isActive = false;
        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);

            preparedStatement = connect
                    .prepareStatement("select isActive from stratego.users WHERE id = ?");
            preparedStatement.setInt(1, userID);
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
    }*/

    /*
    public List<String> getActiveUsers()
    {
        List<String> users =  new ArrayList<String>();
        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);

            preparedStatement = connect
                    .prepareStatement("select username from stratego.users WHERE isActive = TRUE");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                users.add(resultSet.getInt("id") + " : " + resultSet.getString("username"));
            }
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return users;
    }*/

    /*
    public String getID(String sessionID)
    {
        String user ="";
        try {
            // Setup the connection with the DB
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
    }*/

    /*
    public void setSessionID(String sessionID, String user, String pass)
    {
        try {
            // Setup the connection with the DB
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
    }*/

    public String validateUserName(String usname)
    {
        String user = "";
        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);
            preparedStatement = connect
                    .prepareStatement("select username from stratego.users WHERE username = ?");
            preparedStatement.setString(1, usname);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                user = resultSet.getString("username");
            }
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());

        }

        return user;
    }

    public String getUserAttributes(int userId)
    {
        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);
            preparedStatement = connect
                    .prepareStatement("select username from stratego.users WHERE id = ?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            connect.close();
            if (resultSet.next())
            {
                String name = resultSet.getString("username");
                int id = resultSet.getInt("id");

                return id + ":" + name;
            }
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());

        }
        throw new RuntimeException("Failed to get user: " + userId);
    }

    public String getUserAttributes(String userName)
    {
        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);
            preparedStatement = connect
                    .prepareStatement("select username from stratego.users WHERE username = ?");
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            connect.close();
            if (resultSet.next())
            {
                String name = resultSet.getString("username");
                int id = resultSet.getInt("id");

                return id + ":" + name;
            }
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());

        }
        throw new RuntimeException("Failed to get user: " + userName);
    }

    public boolean checkPassword(String user, String pass)
    {
        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);
            preparedStatement = connect
                    .prepareStatement("select password from stratego.users WHERE username = ?");
            preparedStatement.setString(1, user);
            ResultSet resultSet = preparedStatement.executeQuery();

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
