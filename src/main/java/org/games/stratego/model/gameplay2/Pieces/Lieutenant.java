package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay2.Player;

public class Lieutenant extends Piece {

    private String name = "lieutenant";
    private boolean canMove = true;
    private int rank = 5;

    public Lieutenant(Player owner)
    {
        this.name = "lieutenant";
        this.owner = owner;
    }


    @Override
    public String getType()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return "lieutenant";
    }

    public String toString()
    {
        return owner.getName() + ":lieutenant";
    }
}
