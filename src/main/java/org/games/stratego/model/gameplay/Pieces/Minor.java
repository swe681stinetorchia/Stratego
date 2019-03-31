package org.games.stratego.model.gameplay.Pieces;

import org.games.stratego.model.gameplay.Player;

public class Minor extends Piece{

    private String name = "minor";
    private boolean canMove = true;
    private int rank = 3;

    public Minor(Player owner)
    {
        this.owner = owner;
    }
}
