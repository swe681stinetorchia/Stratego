package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay2.Player;

public class Spy extends Piece {

    private String name = "spy";
    private boolean canMove = true;
    private int rank = 1;

    public Spy(Player owner)
    {
        this.owner = owner;
        this.name = "spy";
    }

    @Override
    public String getType()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return "spy";
    }
}
