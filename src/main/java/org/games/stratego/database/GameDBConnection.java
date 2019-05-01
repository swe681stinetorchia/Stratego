package org.games.stratego.database;

import org.apache.log4j.Logger;
import org.games.stratego.Services.StrategoGetPropertyValues;

import java.sql.*;


public class GameDBConnection extends StrategoDBConnection{

    public void addGame(String playerOneID, String playerTwoID)
    {
        try {
            preparedStatement = connect
                    .prepareStatement("insert into stratego.player (UUID(), ?, ?, SYSDATE(), SYSDATE())");
            preparedStatement.setString(1, playerOneID);
            preparedStatement.setString(2, playerTwoID);
            resultSet = preparedStatement.executeQuery();
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
    }


}



