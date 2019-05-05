package org.games.stratego.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.games.stratego.Services.StrategoGetPropertyValues;
import org.games.stratego.model.gameplay.Game;

import java.sql.*;
import java.util.UUID;


public class GameDBConnection extends StrategoDBConnection{

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

    public void getGame(String gameId)
    {
        try
        {
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
        }

    }


}



