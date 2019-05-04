package org.games.stratego.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.games.stratego.Services.StrategoGetPropertyValues;

import java.sql.*;


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
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
    }

    public void addGame(String playerOneID, String playerTwoID)
    {
        try {
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(url, username, password);

            preparedStatement = connect
                    .prepareStatement("insert into stratego.player (id, player_one, player_two, startTime) (UUID(), ?, ?, SYSDATE())");
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



