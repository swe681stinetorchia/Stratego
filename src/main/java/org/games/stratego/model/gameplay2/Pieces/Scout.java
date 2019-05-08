package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay2.Player;

public class Scout extends Piece {

    private String name = "scout";
    private boolean canMove = true;
    private int rank = 2;

    public Scout(Player owner)
    {
        this.owner = owner;
        this.name = "scout";
    }

    @Override
    public String getType()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return "scout";
    }
}
