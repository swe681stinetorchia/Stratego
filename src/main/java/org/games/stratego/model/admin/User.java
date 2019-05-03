package org.games.stratego.model.admin;

public class User {
    private String name;

    public User(String name, String password)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
