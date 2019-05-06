package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay.Player;

public class Sergeant extends Piece {

    private String name = "sergeant";
    private boolean canMove = true;
    private int rank = 4;

    public Sergeant(Player owner)
    {
        this.owner = owner;
    }
}
