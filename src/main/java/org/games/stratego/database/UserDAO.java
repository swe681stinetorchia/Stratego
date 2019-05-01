package org.games.stratego.database;

import java.sql.*;

public class UserDAO {

    private Connection connect = null;
    private final String URL= "jdbc:mysql://127.0.0.1:3306/classicmodels?useSSL=false";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "g3ntlemenST@Rty0ur$nTine$";

    private static final String ADD_USER_QUERY =
            "insert into users(username, password) values(?, ?)";


    private static final String LAST_ID_QUERY =
            "select LAST_INSERT_ID()";


    public UserDAO()
    {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.out.println("JAVA: Class.forName() error");
            e.printStackTrace();
        }
    }

    public int addUser(String name, String password)
    {
        try
        {
            connect = DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement addUSerStatement = connect.prepareStatement(ADD_USER_QUERY);
            addUSerStatement.setString(1, name);
            addUSerStatement.setString(2, password);
            addUSerStatement.executeUpdate();
            PreparedStatement getId = connect.prepareStatement(LAST_ID_QUERY);
            ResultSet rs = getId.executeQuery();

            int id = 0;
            if (rs.next())
            {
                rs.getInt(0);
            }
            else
            {
                throw new RuntimeException("add user request did not produce an id");
            }
            return id;
        }
        catch (SQLException sqe)
        {
            sqe.printStackTrace();
        }
        finally
        {
            if( connect != null ) {
                try {
                    connect.close();
                } catch( SQLException e ) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
}
