package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay2.Player;

public class Colonel extends Piece {

    private String name = "colonel";
    private boolean canMove = true;
    private int rank = 8;

    public Colonel(Player owner)
    {
        this.owner = owner;
    }


    @Override
    public String getType()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return "colonel";
    }

    public String toString()
    {
        return owner.getName() + ":colonel";
    }
}
