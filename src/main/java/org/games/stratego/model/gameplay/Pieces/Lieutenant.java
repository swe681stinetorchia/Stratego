package org.games.stratego.model.gameplay.Pieces;

import org.games.stratego.model.gameplay.Player;

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

    @Override
    public boolean canMove()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return canMove;
    }

    public String toString()
    {
        return owner.getName() + ":lieutenant";
    }
}
