package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay2.Player;

public class Marshal extends Piece {

    private String name = "marshal";
    private boolean canMove = true;
    private int rank = 10;

    public Marshal(Player owner)
    {
        this.owner = owner;
    }


    @Override
    public String getType()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return "marshal";
    }

    public String toString()
    {
        return owner.getName() + ":marshal";
    }
}
