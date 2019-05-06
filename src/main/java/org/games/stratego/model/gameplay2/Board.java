package org.games.stratego.model.gameplay2;
import org.games.stratego.database.BoardDBConnection;
import org.games.stratego.model.gameplay2.Pieces.Piece;

public class Board
{
    // 10 x 10 Grid
    Square[][] board = new Square[10][10];

    //Instantiate new board and add to db
    public Board()
    {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                Square square = new Square(row, col);
                board[row][col] = square;
            }
        }
    }

    //Load preexisting board from db
    public Board(String gameId)
    {
        String col_name;
        String piece_id;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                col_name ="position_" + row + "_" + col;
                //Need to bring in game_id
                BoardDBConnection db = new BoardDBConnection();
                piece_id = db.getPiece(col_name, gameId);
                //board[row][col] = db.getPiece(col_name, gameId);
            }
        }

        /**
        for (int row = 0; row < board.length; row++) {
            System.out.print((row + 1) + "\t");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + "\t");
            }
            System.out.println();
        }
        System.out.print("\t");
        for(int row = 0; row < 10; row++) {
            System.out.print((row + 1) + "\t");
        }*/
    }

    protected void addPiece(int row, int col, Piece piece)
    {
        board[row][col].addPiece(piece);
    }

    protected FightResult move(int fromRow, int fromCol, int toRow, int toCol)
    {
        Square fromSquare = board[fromRow][fromCol];
        Square toSquare = board[toRow][toCol];

        if (!fromSquare.hasPiece())
        {
            return FightResult.IllegalMove;
        }

        Piece piece = fromSquare.getPiece();

        if (!toSquare.hasPiece())
        {
            fromSquare.removePiece();
            toSquare.addPiece(piece);
            return FightResult.SuccessfulMove;
        }
        else
        {
            Piece resident = toSquare.getPiece();
            if (piece.getOwner()==resident.getOwner())
            {
                return FightResult.IllegalMove;
            }
            FightResult fightResult = resident.fight(piece);
            if (fightResult==FightResult.DefenderVictory)
            {
                fromSquare.removePiece();
                piece.kill();
                return fightResult;
            }
            if (fightResult==FightResult.AttackerVictory)
            {
                fromSquare.removePiece();
                toSquare.removePiece();
                toSquare.addPiece(piece);
                resident.kill();
                return fightResult;
            }
            if (fightResult==FightResult.BothDie)
            {
                fromSquare.removePiece();
                toSquare.removePiece();
                piece.kill();
                resident.kill();
            }
            if (fightResult==FightResult.CapturedFlag)
            {
                clearBoard();
                return fightResult;
            }
            if (fightResult==FightResult.IllegalMove)
            {
                return fightResult;
            }
            return FightResult.UndefinedResult;
        }
    }

    private void clearBoard()
    {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(board[row][col].hasPiece())
                {
                    board[row][col].removePiece();
                }
            }
        }
    }

    /**
    public void setGameId(String gameId)
    {

    }

    public Piece getPieceAt(int row, int col)
    {

    }

    public boolean pieceAt(int row, int col)
    {
    }**/
}