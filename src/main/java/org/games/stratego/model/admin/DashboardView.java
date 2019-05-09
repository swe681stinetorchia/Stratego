package org.games.stratego.model.admin;

import org.games.stratego.model.gameplay2.Game;
import org.games.stratego.model.gameplay2.Player;

import java.util.HashMap;
import java.util.Map;

public class DashboardView {

    private Map<String, String> ongoingGames;
    private Map<String, String> completedGames;

    public DashboardView(String username, Map<String, Game> games)
    {

        this.ongoingGames = new HashMap<String, String>();

        this.completedGames = new HashMap<String, String>();

        for(String key: games.keySet())
        {
            Game game = games.get(key);

            Player playerOne = game.getPlayerOne();

            Player playerTwo = game.getPlayerTwo();

            String playerOneName = playerOne.getName();

            String playerTwoName = playerTwo.getName();

            if (username.equals(playerOneName))
            {
                if (game.isGameOver())
                {
                    completedGames.put(playerTwoName, key);
                }
                else
                {
                    ongoingGames.put(playerTwoName, key);
                }
            }

            if (username.equals(playerTwoName))
            {
                if (game.isGameOver())
                {
                    completedGames.put(playerOneName, key);
                }
                else
                {
                    ongoingGames.put(playerOneName, key);
                }
            }
        };
    }

    public Map<String, String> getOngoingGames()
    {
        return ongoingGames;
    }

    public Map<String, String> getCompletedGames()
    {
        return completedGames;
    }
}
