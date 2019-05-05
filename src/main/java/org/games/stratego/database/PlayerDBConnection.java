package org.games.stratego.database;
import org.games.stratego.Services.StrategoGetPropertyValues;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PlayerDBConnection extends StrategoDBConnection {

    public void addPlayer(int userID)
    {

        try {

            preparedStatement = connect
                    .prepareStatement("insert into stratego.player (user_id, lastLogin) VALUES (?, SYSDATE())");
            preparedStatement.setInt(1, userID);
            resultSet = preparedStatement.executeQuery();
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
    }
}
