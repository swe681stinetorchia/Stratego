package org.games.stratego.model.gameplay.Pieces;

import org.games.stratego.model.gameplay.Player;

public class Lieutenant extends Piece{

    private String name = "lieutenant";
    private boolean canMove = true;
    private int rank = 5;

    public Lieutenant(Player owner)
    {
        this.owner = owner;
    }
}
