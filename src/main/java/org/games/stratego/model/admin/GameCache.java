package org.games.stratego.model.admin;

import org.games.stratego.model.gameplay2.Game;

import java.util.HashMap;
import java.util.Map;

public class GameCache {

    private static Map<String, Game> games = new HashMap<String, Game>();

    public static Game getGame(String id) {
        Game game = games.get(id);
        if (game == null) {
            throw new IllegalArgumentException("Game does not exist.");
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

    public static Map<String, Game> getAssignedGames(String username)
    {
        System.out.println("Looking for assigned games for " + username);
        Map<String, Game> assignedGames = new HashMap<String, Game>();
        for (String key: games.keySet())
        {
            Game game = games.get(key);
            User userOne = game.getPlayerOne().getUser();
            User userTwo = game.getPlayerTwo().getUser();
            String userNameOne = userOne.getName();
            String userNameTwo = userTwo.getName();
            System.out.println("Compare " + username + " to " + userNameOne + " and " + userNameTwo + ".");
            if (userNameOne.equals(username)||userNameTwo.equals(username))
            {
                assignedGames.put(key, game);
            }
        }
        return assignedGames;
    }
}