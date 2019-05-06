package org.games.stratego.model.admin;

import org.games.stratego.database.UserDBConnection;

public class User {
    private int id;
    private String name;

    public User(String name, int userId)
    {
        this.name = name;
        this.id = userId;
    }

    public User(int userId)
    {
        UserDBConnection userDBConnection = new UserDBConnection();

        String attributeStr = userDBConnection.getUserAttributes(userId);

        String[] attributes = attributeStr.split(":");

        int foundId = Integer.valueOf(attributes[0]);

        String username = attributes[1];

        this.id = foundId;

        this.name = username;
    }

    public String getName()
    {
        return name;
    }
}
