package org.games.stratego.model.gameplay;

import org.games.stratego.model.gameplay.Pieces.Piece;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private Map<Integer, Map<Integer, Square>> board;
    private Player playerOne;
    private Player playerTwo;
    private Player winner;
    private List<Piece> playerOnePieces;
    private List<Piece> playerTwoPieces;





    private void instantiateBoard()
    {
        board = new HashMap<Integer, Map<Integer, Square>>();

        for (int i = 0; i < 10; i++)
        {

            Map<Integer, Square> row = new HashMap<Integer, Square>();

            for (int j = 0; j < 10; j++)
            {
                Square square = new Square(i, j);

                row.put(j, square);
            }

            board.put(i, row);
        }
    }

}
