package org.games.stratego.model.gameplay2.Pieces;

import org.games.stratego.model.gameplay.FightResult;
import org.games.stratego.model.gameplay.Player;

public class Piece {

    private String name;
    private boolean canMove;
    private int rank;

    boolean isOnBoard;
    boolean isDead;
    Player owner;

    public boolean isDead()
    {
        return isDead;
    }

    public int getRank()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return rank;
    }

    public Player getOwner()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return owner;
    }

    public boolean canMove()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return canMove;
    }

    public boolean isOnBoard()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return isOnBoard;
    }

    public String getType()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        return name;
    }

    public void kill()
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        isDead = true;
    }

    public void addToBoard()
    {
        isOnBoard = true;
    }

    public void removeFromBoard()
    {
        isOnBoard = false;
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

    /**public Piece(String name, boolean canMove, int rank)
    {
        this.name = name;
        this.canMove = canMove;
        this.rank = rank;
    }**/


}
