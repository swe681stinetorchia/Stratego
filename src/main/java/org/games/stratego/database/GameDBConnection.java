package org.games.stratego.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.games.stratego.Services.StrategoGetPropertyValues;
import java.sql.*;
import java.util.UUID;


public class GameDBConnection {

    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private final Logger log = LogManager.getLogger(getClass());
    private String url;
    private String username;
    private String password;

    public GameDBConnection() {
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

    public String addGame(int playerOneID, int playerTwoID)
    {
        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);

            String uuid = UUID.randomUUID().toString();
            preparedStatement = connect
                    .prepareStatement("insert into stratego.game (id, player_one, player_two, startTime) (?, ?, ?, SYSDATE())");
            preparedStatement.setString(1, uuid);
            preparedStatement.setInt(2, playerOneID);
            preparedStatement.setInt(3, playerTwoID);
            preparedStatement.setInt(1, playerOneID);
            preparedStatement.setInt(2, playerTwoID);
            int result = preparedStatement.executeUpdate();
            connect.close();

            if (result != 1)
            {
                throw new RuntimeException("Failed to create game.");
            }
            return uuid;
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
            return "none";
        }
    }

    public int getLoserId(int gameId)
    {
        int loserId = -1;

        try
        {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);
            preparedStatement = connect
                    .prepareStatement("select loser from stratego.game where id = ?");
            preparedStatement.setInt(1, gameId);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next())
            {
                loserId = resultSet.getInt("loser");
            }
            else
            {
                throw new IllegalArgumentException("game " + gameId + " does not exist");
            }
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return loserId;
    }

    public int getWinnerId(int gameId)
    {
        int winnerId = -1;

        try
        {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);
            preparedStatement = connect
                    .prepareStatement("select winner from stratego.game where id = ?");
            preparedStatement.setInt(1, gameId);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next())
            {
                winnerId = resultSet.getInt("winner");
            }
            else
            {
                throw new IllegalArgumentException("game " + gameId + " does not exist");
            }
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return winnerId;
    }

    public int getPlayerOneId(int gameId)
    {
        int playerOneId = -1;

        try
        {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);
            preparedStatement = connect
                    .prepareStatement("select player_one from stratego.game where id = ?");
            preparedStatement.setInt(1, gameId);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next())
            {
                playerOneId = resultSet.getInt("player_one");
            }
            else
            {
                throw new IllegalArgumentException("game " + gameId + " does not exist");
            }
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return playerOneId;
    }

    public int getPlayerTwoId(int gameId)
    {
        int playerTwoId = -1;

        try
        {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);
            preparedStatement = connect
                    .prepareStatement("select player_two from stratego.game where id = ?");
            preparedStatement.setInt(1, gameId);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next())
            {
                playerTwoId = resultSet.getInt("player_two");
            }
            else
            {
                throw new IllegalArgumentException("game " + gameId + " does not exist");
            }
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return playerTwoId;
    }


}



