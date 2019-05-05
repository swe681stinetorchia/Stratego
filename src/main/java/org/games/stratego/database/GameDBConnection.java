package org.games.stratego.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.games.stratego.Services.StrategoGetPropertyValues;
import org.games.stratego.model.gameplay.Game;

import java.sql.*;
import java.util.UUID;


public class GameDBConnection extends StrategoDBConnection{

    protected Connection connect = null;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;
    protected final Logger log = LogManager.getLogger(getClass());
    protected String url;
    protected String username;
    protected String password;

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

    public String addGame(String playerOneID, String playerTwoID)
    {
        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);

            String uuid = UUID.randomUUID().toString();
            preparedStatement = connect
                    .prepareStatement("insert into stratego.game (id, player_one, player_two, startTime) (?, ?, ?, SYSDATE())");
            preparedStatement.setString(1, uuid);
            preparedStatement.setString(2, playerOneID);
            preparedStatement.setString(3, playerTwoID);
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

    public Game getGame(String gameId)
    {
        try
        {
            connect = DriverManager
                    .getConnection(url, username, password);
            preparedStatement = connect
                    .prepareStatement("select * from stratego.game where id = ?");
            preparedStatement.setString(1, gameId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
            {

            }

        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
            return null;
        }

    }


}



