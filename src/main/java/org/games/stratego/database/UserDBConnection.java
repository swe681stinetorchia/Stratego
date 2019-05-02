package org.games.stratego.database;

import org.apache.log4j.Logger;
import org.games.stratego.Services.StrategoGetPropertyValues;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDBConnection extends StrategoDBConnection {

    public void addUser(String username, String password)
    {

        try {
            preparedStatement = connect
                    .prepareStatement("insert into stratego.users (UUID(), ?, ?, TRUE, SYSDATE())");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
    }
    public Boolean isActiveUser(String userID)
    {
        Boolean isActive = false;
        try {
            preparedStatement = connect
                    .prepareStatement("select isActive from stratego.users WHERE id = ?");
            preparedStatement.setString(1, userID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                isActive = Boolean.parseBoolean(resultSet.getString("isActive"));
            }
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return isActive;
    }

    public List getActiveUsers()
    {
        List<String> users =  new ArrayList<String>();
        try {
            preparedStatement = connect
                    .prepareStatement("select username from stratego.users WHERE isActive = TRUE");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                users.add(resultSet.getString("username"));
            }
            connect.close();
        }
        catch (SQLException e) {
            log.fatal(e.getMessage());
        }
        return users;
    }
}
