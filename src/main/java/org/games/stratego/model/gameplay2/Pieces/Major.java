package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay2.Player;

public class Major extends Piece {

    private String name = "major";
    private boolean canMove = true;
    private int rank = 7;

    public Major(Player owner)
    {
        this.owner = owner;
    }


    @Override
    public String getType()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return "major";
    }
}
