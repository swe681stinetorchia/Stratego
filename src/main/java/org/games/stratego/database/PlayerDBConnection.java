package org.games.stratego.database;
import org.games.stratego.Services.StrategoGetPropertyValues;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;


public class PlayerDBConnection extends StrategoDBConnection {

    public void addPlayer(String userID)
    {

        try {
            preparedStatement = connect
                    .prepareStatement("insert into stratego.player (UUID(), ?, SYSDATE())");
            preparedStatement.setString(1, userID);
            resultSet = preparedStatement.executeQuery();
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
    }
}
