package org.games.stratego.model.admin;

import org.games.stratego.database.GameDBConnection;
import org.games.stratego.database.UserDBConnection;
import org.games.stratego.model.gameplay.Game;
import org.games.stratego.model.gameplay.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardView {

    private Map<String, String> ongoingGames;
    private List<String> victories;
    private List<String> defeats;

    public DashboardView(String username, Map<String, Game> games)
    {

        this.ongoingGames = new HashMap<String, String>();

        for(String key: games.keySet())
        {
            Game game = games.get(key);

            Player playerOne = game.getPlayerOne();

            Player playerTwo = game.getPlayerTwo();

            String playerOneName = playerOne.getName();

            String playerTwoName = playerTwo.getName();

            if (username.equals(playerOneName))
            {
                ongoingGames.put(playerTwoName, key);
            }

            if (username.equals(playerTwoName))
            {
                ongoingGames.put(playerOneName, key);
            }
        }

        GameDBConnection gameDBConnection = new GameDBConnection();
        List<String> wins = gameDBConnection.getMyWins(username);
        List<String> losses = gameDBConnection.getMyLosses(username);

        UserDBConnection userDBConnection = new UserDBConnection();

        for (String gameId: wins)
        {
            List<String> moves = userDBConnection.getGameMoves(gameId);
            victories.add(gameId + ": " + moves.toString());
        }
        for (String gameId: losses)
        {
            List<String> moves = userDBConnection.getGameMoves(gameId);
            defeats.add(gameId + ": " + moves.toString());
        }
    }

    public Map<String, String> getOngoingGames()
    {
        return ongoingGames;
    }

    public List<String> getVictories() {return victories;}

    public List<String> getDefeats() {return  defeats;}
}
