package org.games.stratego.model.gameplay;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private Map<Integer, Map<Integer, Square>> boardMatrix;

    public Board()
    {
        boardMatrix = new HashMap<Integer, Map<Integer, Square>>();

        for (int i = 0; i < 10; i++)
        {

            Map<Integer, Square> row = new HashMap<Integer, Square>();

            for (int j = 0; j < 10; j++)
            {
                Square square = new Square(i, j);

                row.put(j, square);
            }

            boardMatrix.put(i, row);
        }
    }


}
