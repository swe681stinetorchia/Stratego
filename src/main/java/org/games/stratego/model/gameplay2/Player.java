package org.games.stratego.model.gameplay2;

import org.games.stratego.model.admin.User;

public class Player {

    private String name;
    private User user;

    public Player(String name, User user)
    {
        this.name = name;
        this.user = user;
    }

    public String getName()
    {
        return name;
    }

    public User getUser() {return user;}
}
