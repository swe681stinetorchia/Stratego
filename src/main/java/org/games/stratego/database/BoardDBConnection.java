package org.games.stratego.database;

public class BoardDBConnection extends StrategoDBConnection {

    public String getPiece(String col_name, String game_id)
    {
        String returnVal = "";

        try {
            preparedStatement = connect
                    .prepareStatement("select ? from stratego.board where game_id=?");
            preparedStatement.setString(1, col_name);
            preparedStatement.setString(2, game_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                returnVal = resultSet.getString(col_name);
            }
            connect.close();
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
        return returnVal;
    }

    public String getOwner(String pieceID)
    {
        String returnVal = "";

        try {
            preparedStatement = connect
                    .prepareStatement("select owner from stratego.piece where piece_id=?");
            preparedStatement.setString(1, pieceID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                returnVal = resultSet.getString("owner");
            }
            connect.close();
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
        return returnVal;
    }
}
