package org.games.stratego.model.admin;

import java.sql.Date;

public class game {
   int id;
    int player_one;
    int player_two;
   Date startTime;
   int winner;
   int loser;
   int nextTurn;

  public game(int id, int player_one, int player_two, Date startTime, int winner, int loser, int nextTurn)
  {
      this.id = id;
      this.player_one = player_one;
      this.player_two = player_two;
      this.startTime = startTime;
      this.winner = winner;
      this.loser = loser;
      this.nextTurn = nextTurn;
  }
}
