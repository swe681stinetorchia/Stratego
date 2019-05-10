package org.games.stratego.model.gameplay.Pieces;

import org.games.stratego.model.gameplay.Player;

public class Captain extends Piece {

    private String name = "captain";
    private boolean canMove = true;
    private int rank = 6;

    public Captain(Player owner)
    {
        this.owner = owner;
    }


    @Override
    public String getType()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return "captain";
    }

    public String toString()
    {
        return owner.getName() + ":captain";
    }

    @Override
    public boolean canMove()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return canMove;
    }
}
