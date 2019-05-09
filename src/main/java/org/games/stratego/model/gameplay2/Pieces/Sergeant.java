package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay2.Player;

public class Sergeant extends Piece {

    private String name = "sergeant";
    private boolean canMove = true;
    private int rank = 4;

    public Sergeant(Player owner)
    {
        this.name = "sergeant";
        this.owner = owner;
    }

    @Override
    public String getType()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return "sergeant";
    }

    public String toString()
    {
        return owner.getName() + ":sergeant";
    }
}
