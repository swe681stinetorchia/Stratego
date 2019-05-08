package org.games.stratego.model.admin;

import org.games.stratego.model.gameplay2.Game;

import java.util.HashMap;
import java.util.Map;

public class GameCache {

    private static Map<String, Game> games = new HashMap<String, Game>();

    public static Game getGame(String id) {
        Game game = games.get(id);
        if (game == null) {
            return null;
        }
        return game;
    }

    public static void addGame(String id, Game game)
    {
        //check for pre-existing sessions
        for (String key : games.keySet())
        {
            if (game==games.get(key))
            {
                games.remove(key);
            }
        }

        games.put(id, game);
    }

    public static void removeGame(String id)
    {
        games.remove(id);
    }

    public Map<String, Game> getAssignedGames(User user)
    {
        Map<String, Game> assignedGames = new HashMap<String, Game>();
        for (String key: games.keySet())
        {
            Game game = games.get(key);
            User userOne = game.getPlayerOne().getUser();
            User userTwo = game.getPlayerTwo().getUser();
            if (user==userOne||user==userTwo)
            {
                assignedGames.put(key, game);
            }
        }
        return assignedGames;
    }
}