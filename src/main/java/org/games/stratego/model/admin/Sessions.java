package org.games.stratego.model.admin;

import java.util.HashMap;
import java.util.Map;

public class Sessions {

    private static Map<String, String> sessions = new HashMap<String, String>();

    public static String checkSession(String token) {
        String username = sessions.get(token);
        if (username == null) {
            return "None";
        }
        return username;
    }

    public static void addSession(String token, String username)
    {
        //check for pre-existing sessions
        for (String key : sessions.keySet())
        {
            if (username.equals(sessions.get(key)))
            {
                sessions.remove(key);
            }
        }

        sessions.put(token, username);
    }
}
