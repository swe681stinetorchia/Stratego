package org.games.stratego.database;

import org.games.stratego.Services.StrategoGetPropertyValues;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class BoardDBConnection extends StrategoDBConnection {


    public String getPiece(String col_name, String game_id)
    {
        String returnVal = "";

        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);

            preparedStatement = connect
                    .prepareStatement("select ? from stratego.board where game_id=?");
            preparedStatement.setString(1, col_name);
            preparedStatement.setString(2, game_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                returnVal = resultSet.getString(col_name);
            }
            connect.close();
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
        return returnVal;
    }

    public String getPieceRank(String piece_id)
    {
        String returnVal = "";

        try {

            preparedStatement = connect
                    .prepareStatement("select piece from piece_lookup as a join piece as b on a.piece_id = b.piece_id where b.id = ?");
            preparedStatement.setString(1, piece_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                returnVal = resultSet.getString("piece");
            }
            connect.close();
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
        return returnVal;
    }

    public String getOwner(String pieceID)
    {
        String returnVal = "";

        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);

            preparedStatement = connect
                    .prepareStatement("select owner from stratego.piece where piece_id=?");
            preparedStatement.setString(1, pieceID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                returnVal = resultSet.getString("owner");
            }
            connect.close();
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
        return returnVal;
    }

    public void createBoard(String gameId)
    {
        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);

            preparedStatement = connect
                    .prepareStatement("insert into stratego.board(game_id) values(?)");
            preparedStatement.setString(1, gameId);
            int result = preparedStatement.executeUpdate();
            connect.close();

            if (result!=1)
            {
                throw new Exception("Failed to execute createBoard for game " + gameId);
            }
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
    }

    public void addPiece(String gameId, String piece)
    {
        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);

            preparedStatement = connect
                    .prepareStatement("update stratego.board set piece_id = ? where game_id = ?");
            preparedStatement.setString(1, piece);
            preparedStatement.setString(2, gameId);
            int result = preparedStatement.executeUpdate();
            connect.close();

            if (result!=1)
            {
                throw new Exception("Failed to execute addPiece for game " + gameId);
            }
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }

    }
}
