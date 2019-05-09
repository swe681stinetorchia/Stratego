package org.games.stratego.model.admin;

import java.util.Map;

public class DashboardView {

    private Map<String, String> ongoingGames;
    private Map<String, String> completedGames;

    public DashboardView(Map<String, String> ongoing, Map<String, String> completed)
    {
        this.ongoingGames = ongoing;
        this.completedGames = completed;
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
