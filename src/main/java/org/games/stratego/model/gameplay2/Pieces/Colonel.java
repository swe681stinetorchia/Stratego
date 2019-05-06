package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay.Player;

public class Colonel extends Piece {

    private String name = "colonel";
    private boolean canMove = true;
    private int rank = 8;

    public Colonel(Player owner)
    {
        this.owner = owner;
    }
}
