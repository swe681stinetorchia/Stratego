package org.games.stratego.model.gameplay2;

import org.games.stratego.model.admin.User;
import org.games.stratego.model.gameplay2.Pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private User user;

    public Player(User user)
    {
        this.name = user.getName();
        this.user = user;
    }

    public String getName()
    {
        return name;
    }

    public User getUser() {return user;}
}
