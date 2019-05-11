package org.games.stratego.database;

import org.games.stratego.Services.StrategoGetPropertyValues;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PlayerDBConnection {

    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private final Logger log = LogManager.getLogger(getClass());
    private String url;
    private String username;
    private String password;

    public PlayerDBConnection() {
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

    /*
    public void addPlayer(int userID)
    {

        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);

            preparedStatement = connect
                    .prepareStatement("insert into stratego.player (user_id, lastLogin) VALUES (?, SYSDATE())");
            preparedStatement.setInt(1, userID);
            int result = preparedStatement.executeUpdate();
            if (result != 1)
            {
                throw new RuntimeException("Failed to perform update.");
            }
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
    }*/

    public int getUserId(int playerId)
    {
        int userId = -1;

        try
        {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);
            preparedStatement = connect
                    .prepareStatement("select user_id from stratego.game where id = ?");
            preparedStatement.setInt(1, playerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                userId = resultSet.getInt("user_id");
            }
            else
            {
                throw new IllegalArgumentException("player " + playerId + " does not exist");
            }
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return userId;
    }

    public int getLosses(int playerId)
    {
        int losses = 0;

        try
        {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);
            preparedStatement = connect
                    .prepareStatement("select count(loser) as losses from stratego.game where loser =?");
            preparedStatement.setInt(1, playerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            losses = resultSet.getInt("losses");

        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return losses;
    }

    public int getWins(int playerId)
    {
        int wins = 0;

        try
        {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);
            preparedStatement = connect
                    .prepareStatement("select count(winner) as wins from stratego.game where winner =?");
            preparedStatement.setInt(1, playerId);
            ResultSet resultSet = preparedStatement.executeQuery();
                wins = resultSet.getInt("wins");

        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return wins;
    }
}
