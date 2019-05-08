package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay2.Player;

public class Minor extends Piece {

    private String name = "minor";
    private boolean canMove = true;
    private int rank = 3;

    public Minor(Player owner)
    {
        this.owner = owner;
    }


    @Override
    public String getType()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return "minor";
    }
}
