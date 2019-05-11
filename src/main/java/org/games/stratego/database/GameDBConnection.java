package org.games.stratego.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.games.stratego.Services.StrategoGetPropertyValues;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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

    public void addCompletedGame(String gameId, String winner, String loser )
    {
        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);

            preparedStatement = connect
                    .prepareStatement("insert into stratego.game (id, winner, loser, startTime) (?, ?, ?, SYSDATE())");
            preparedStatement.setString(1, gameId);
            preparedStatement.setString(4, winner);
            preparedStatement.setString(5, loser);
            int result = preparedStatement.executeUpdate();
            if (result != 1)
            {
                connect.close();
                throw new RuntimeException("Failed to create game.");
            }
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
    }

    public List<String> getMyWins(String user)
    {
        List<String> wins = new ArrayList<String>();
        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);

            preparedStatement = connect
                    .prepareStatement("select id, loser from stratego.game where winner=?");
            preparedStatement.setString(1, user);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                String id = resultSet.getString("id");
                wins.add(id);
            }
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return wins;
    }

    public List<String> getMyLosses(String user)
    {
        List<String> losses = new ArrayList<String>();
        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);

            preparedStatement = connect
                    .prepareStatement("select id, winner from stratego.game where loser=?");
            preparedStatement.setString(1, user);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                String id = resultSet.getString("id");
                losses.add(id);
            }
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return losses;
    }

    /*
    public String getLoserId(String gameId)
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
                connect.close();
                throw new IllegalArgumentException("game " + gameId + " does not exist");
            }
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return loserId;
    }

    public String getWinnerId(String gameId)
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
                connect.close();
                throw new IllegalArgumentException("game " + gameId + " does not exist");
            }
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return winnerId;
    }

    public String getPlayerOneId(String gameId)
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
                connect.close();
                throw new IllegalArgumentException("game " + gameId + " does not exist");
            }
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return playerOneId;
    }

    public String getPlayerTwoId(String gameId)
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
                connect.close();
                throw new IllegalArgumentException("game " + gameId + " does not exist");
            }
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return playerTwoId;
    }

    public void gameOver (String gameId, int winnerId, int loserId) {
        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);
            preparedStatement = connect
                    .prepareStatement("update stratego.game set winner = ?, loser = ? where id = ?");
            preparedStatement.setInt(1, winnerId);
            preparedStatement.setInt(2, loserId);
            preparedStatement.setString(3, gameId);
            preparedStatement.executeQuery();

        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
    }*/


}



