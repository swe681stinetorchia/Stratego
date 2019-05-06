package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay.Player;

public class Spy extends Piece {

    private String name = "spy";
    private boolean canMove = true;
    private int rank = 1;

    public Spy(Player owner)
    {
        this.owner = owner;
    }
}
