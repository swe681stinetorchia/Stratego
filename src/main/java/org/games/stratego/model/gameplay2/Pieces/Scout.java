package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay.Player;

public class Scout extends Piece {

    private String name = "scout";
    private boolean canMove = true;
    private int rank = 2;

    public Scout(Player owner)
    {
        this.owner = owner;
    }
}
