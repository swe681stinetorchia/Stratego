package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay2.Player;

public class General extends Piece {

    private String name = "general";
    private boolean canMove = true;
    private int rank = 9;

    public General(Player owner)
    {
        this.owner = owner;
    }
}