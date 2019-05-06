package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay.Player;

public class Captain extends Piece {

    private String name = "captain";
    private boolean canMove = true;
    private int rank = 6;

    public Captain(Player owner)
    {
        this.owner = owner;
    }
}
