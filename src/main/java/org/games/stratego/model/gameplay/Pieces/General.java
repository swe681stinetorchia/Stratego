package org.games.stratego.model.gameplay.Pieces;

import org.games.stratego.model.gameplay.Player;

public class General extends Piece{

    private String name = "general";
    private boolean canMove = true;
    private int rank = 9;

    public General(Player owner)
    {
        this.owner = owner;
    }
}
