package org.games.stratego.model.gameplay.Pieces;

import org.games.stratego.model.gameplay.FightResult;
import org.games.stratego.model.gameplay.Player;

public class Captain extends Piece {

    private String name = "captain";
    private boolean canMove = true;
    private int rank = 6;

    public Captain(Player owner)
    {
        this.owner = owner;
    }


    @Override
    public String getType()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return "captain";
    }

    public String toString()
    {
        return owner.getName() + ":captain";
    }

    @Override
    public boolean canMove()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return canMove;
    }

    @Override
    public int getRank()
    {
        return rank;
    }

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

        if (piece.getRank() > this.rank)
        {
            return FightResult.AttackerVictory;
        }

        if (piece.getRank() == this.rank)
        {
            return FightResult.BothDie;
        }

        if (piece.getRank() < this.getRank())
        {
            return FightResult.DefenderVictory;
        }

        return FightResult.UndefinedResult;
    }
}
