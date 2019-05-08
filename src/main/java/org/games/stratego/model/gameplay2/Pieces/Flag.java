package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay2.FightResult;
import org.games.stratego.model.gameplay2.Player;

public class Flag extends Piece {

    private String name = "flag";
    private boolean canMove = false;
    private int rank = 0;

    public Flag(Player owner)
    {
        this.owner = owner;
    }

    @Override
    public FightResult fight(Piece piece)
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        if (piece.getOwner()==null)
        {
            throw new IllegalStateException("Attacker has no rank.");
        }

        if (piece.isDead())
        {
            throw new IllegalStateException("Attacker is alredy dead");
        }

        if (piece.getOwner()==null)
        {
            throw new IllegalStateException("Attacker has no owner");
        }

        if (piece.getOwner() == this.owner)
        {
            return FightResult.IllegalMove;
        }

        return FightResult.CapturedFlag;
    }


    @Override
    public String getType()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return "flag";
    }
}
