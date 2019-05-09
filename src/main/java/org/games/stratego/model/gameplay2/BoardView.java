package org.games.stratego.model.gameplay2;

import org.games.stratego.model.admin.Sessions;
import org.games.stratego.model.gameplay2.Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class BoardView {

    private String sq11 = "empty";
    private String sq12 = "empty";
    private String sq13 = "empty";
    private String sq14 = "empty";
    private String sq15 = "empty";
    private String sq16 = "empty";
    private String sq17 = "empty";
    private String sq18 = "empty";
    private String sq19 = "empty";
    private String sq110 = "empty";
    private String sq21 = "empty";
    private String sq22 = "empty";
    private String sq23 = "empty";
    private String sq24 = "empty";
    private String sq25 = "empty";
    private String sq26 = "empty";
    private String sq27 = "empty";
    private String sq28 = "empty";
    private String sq29 = "empty";
    private String sq210 = "empty";
    private String sq31 = "empty";
    private String sq32 = "empty";
    private String sq33 = "empty";
    private String sq34 = "empty";
    private String sq35 = "empty";
    private String sq36 = "empty";
    private String sq37 = "empty";
    private String sq38 = "empty";
    private String sq39 = "empty";
    private String sq310 = "empty";
    private String sq41 = "empty";
    private String sq42 = "empty";
    private String sq43 = "empty";
    private String sq44 = "empty";
    private String sq45 = "empty";
    private String sq46 = "empty";
    private String sq47 = "empty";
    private String sq48 = "empty";
    private String sq49 = "empty";
    private String sq410 = "empty";
    private String sq51 = "empty";
    private String sq52 = "empty";
    private String sq53 = "empty";
    private String sq54 = "empty";
    private String sq55 = "empty";
    private String sq56 = "empty";
    private String sq57 = "empty";
    private String sq58 = "empty";
    private String sq59 = "empty";
    private String sq510 = "empty";
    private String sq61 = "empty";
    private String sq62 = "empty";
    private String sq63 = "empty";
    private String sq64 = "empty";
    private String sq65 = "empty";
    private String sq66 = "empty";
    private String sq67 = "empty";
    private String sq68 = "empty";
    private String sq69 = "empty";
    private String sq610 = "empty";
    private String sq71 = "empty";
    private String sq72 = "empty";
    private String sq73 = "empty";
    private String sq74 = "empty";
    private String sq75 = "empty";
    private String sq76 = "empty";
    private String sq77 = "empty";
    private String sq78 = "empty";
    private String sq79 = "empty";
    private String sq710 = "empty";
    private String sq81 = "empty";
    private String sq82 = "empty";
    private String sq83 = "empty";
    private String sq84 = "empty";
    private String sq85 = "empty";
    private String sq86 = "empty";
    private String sq87 = "empty";
    private String sq88 = "empty";
    private String sq89 = "empty";
    private String sq810 = "empty";
    private String sq91 = "empty";
    private String sq92 = "empty";
    private String sq93 = "empty";
    private String sq94 = "empty";
    private String sq95 = "empty";
    private String sq96 = "empty";
    private String sq97 = "empty";
    private String sq98 = "empty";
    private String sq99 = "empty";
    private String sq910 = "empty";
    private String sq101 = "empty";
    private String sq102 = "empty";
    private String sq103 = "empty";
    private String sq104 = "empty";
    private String sq105 = "empty";
    private String sq106 = "empty";
    private String sq107 = "empty";
    private String sq108 = "empty";
    private String sq109 = "empty";
    private String sq1010 = "empty";

    private String col1 = "1";
    private String col2 = "2";
    private String col3 = "3";
    private String col4 = "4";
    private String col5 = "5";
    private String col6 = "6";
    private String col7 = "7";
    private String col8 = "8";
    private String col9 = "9";
    private String col10 = "10";

    private String row1 = "1";
    private String row2 = "2";
    private String row3 = "3";
    private String row4 = "4";
    private String row5 = "5";
    private String row6 = "6";
    private String row7 = "7";
    private String row8 = "8";
    private String row9 = "9";
    private String row10 = "10";

    private List<String> availablePieces;
    private int piecesLength;

    public BoardView(Game game, String token)
    {
        Player playerOne = game.getPlayerOne();
        Player playerTwo = game.getPlayerTwo();
        String nameOne = playerOne.getName();
        String nameTwo = playerTwo.getName();
        String username = Sessions.checkSession(token);

        if (username.equals(nameOne))
        {
            sq11 = "" + game.getPieceAt(1,1,token) + ".png";
            sq12 = "" + game.getPieceAt(1,2,token) + ".png";
            sq13 =  "" + game.getPieceAt(1,3,token) + ".png";
            sq14 =  "" + game.getPieceAt(1,4,token) + ".png";
            sq15 =  "" + game.getPieceAt(1,5,token) + ".png";
            sq16 =  "" + game.getPieceAt(1,6,token) + ".png";
            sq17 =  "" + game.getPieceAt(1,7,token) + ".png";
            sq18 =  "" + game.getPieceAt(1,8,token) + ".png";
            sq19 =  "" + game.getPieceAt(1,9,token) + ".png";
            sq110 =  "" + game.getPieceAt(1,10,token) + ".png";
            sq21 =  "" + game.getPieceAt(2,1,token) + ".png";
            sq22 =  "" + game.getPieceAt(2,2,token) + ".png";
            sq23 =  "" + game.getPieceAt(2,3,token) + ".png";
            sq24 =  "" + game.getPieceAt(2,4,token) + ".png";
            sq25 =  "" + game.getPieceAt(2,5,token) + ".png";
            sq26 =  "" + game.getPieceAt(2,6,token) + ".png";
            sq27 =  "" + game.getPieceAt(2,7,token) + ".png";
            sq28 =  "" + game.getPieceAt(2,8,token) + ".png";
            sq29 =  "" + game.getPieceAt(2,9,token) + ".png";
            sq210 =  "" + game.getPieceAt(2,10,token) + ".png";
            sq31 =  "" + game.getPieceAt(3,1,token) + ".png";
            sq32 =  "" + game.getPieceAt(3,2,token) + ".png";
            sq33 =  "" + game.getPieceAt(3,3,token) + ".png";
            sq34 =  "" + game.getPieceAt(3,4,token) + ".png";
            sq35 =  "" + game.getPieceAt(3,5,token) + ".png";
            sq36 =  "" + game.getPieceAt(3,6,token) + ".png";
            sq37 =  "" + game.getPieceAt(3,7,token) + ".png";
            sq38 =  "" + game.getPieceAt(3,8,token) + ".png";
            sq39 =  "" + game.getPieceAt(3,9,token) + ".png";
            sq310 =  "" + game.getPieceAt(3,10,token) + ".png";
            sq41 =  "" + game.getPieceAt(4,1,token) + ".png";
            sq42 =  "" + game.getPieceAt(4,2,token) + ".png";
            sq43 =  "" + game.getPieceAt(4,3,token) + ".png";
            sq44 =  "" + game.getPieceAt(4,4,token) + ".png";
            sq45 =  "" + game.getPieceAt(4,5,token) + ".png";
            sq46 =  "" + game.getPieceAt(4,6,token) + ".png";
            sq47 =  "" + game.getPieceAt(4,7,token) + ".png";
            sq48 =  "" + game.getPieceAt(4,8,token) + ".png";
            sq49 =  "" + game.getPieceAt(4,9,token) + ".png";
            sq410 =  "" + game.getPieceAt(4,10,token) + ".png";
            sq51 =  "" + game.getPieceAt(5,1,token) + ".png";
            sq52 =  "" + game.getPieceAt(5,2,token) + ".png";
            sq53 =  "" + game.getPieceAt(5,3,token) + ".png";
            sq54 =  "" + game.getPieceAt(5,4,token) + ".png";
            sq55 =  "" + game.getPieceAt(5,5,token) + ".png";
            sq56 =  "" + game.getPieceAt(5,6,token) + ".png";
            sq57 =  "" + game.getPieceAt(5,7,token) + ".png";
            sq58 =  "" + game.getPieceAt(5,8,token) + ".png";
            sq59 =  "" + game.getPieceAt(5,9,token) + ".png";
            sq510 =  "" + game.getPieceAt(5,10,token) + ".png";
            sq61 =  "" + game.getPieceAt(6,1,token) + ".png";
            sq62 =  "" + game.getPieceAt(6,2,token) + ".png";
            sq63 =  "" + game.getPieceAt(6,3,token) + ".png";
            sq64 =  "" + game.getPieceAt(6,4,token) + ".png";
            sq65 =  "" + game.getPieceAt(6,5,token) + ".png";
            sq66 =  "" + game.getPieceAt(6,6,token) + ".png";
            sq67 =  "" + game.getPieceAt(6,7,token) + ".png";
            sq68 =  "" + game.getPieceAt(6,8,token) + ".png";
            sq69 =  "" + game.getPieceAt(6,9,token) + ".png";
            sq610 =  "" + game.getPieceAt(6,10,token) + ".png";
            sq71 =  "" + game.getPieceAt(7,1,token) + ".png";
            sq72 =  "" + game.getPieceAt(7,2,token) + ".png";
            sq73 =  "" + game.getPieceAt(7,3,token) + ".png";
            sq74 =  "" + game.getPieceAt(7,4,token) + ".png";
            sq75 =  "" + game.getPieceAt(7,5,token) + ".png";
            sq76 =  "" + game.getPieceAt(7,6,token) + ".png";
            sq77 =  "" + game.getPieceAt(7,7,token) + ".png";
            sq78 =  "" + game.getPieceAt(7,8,token) + ".png";
            sq79 =  "" + game.getPieceAt(7,9,token) + ".png";
            sq710 =  "" + game.getPieceAt(7,10,token) + ".png";
            sq81 =  "" + game.getPieceAt(8,1,token) + ".png";
            sq82 =  "" + game.getPieceAt(8,2,token) + ".png";
            sq83 =  "" + game.getPieceAt(8,3,token) + ".png";
            sq84 =  "" + game.getPieceAt(8,4,token) + ".png";
            sq85 =  "" + game.getPieceAt(8,5,token) + ".png";
            sq86 =  "" + game.getPieceAt(8,6,token) + ".png";
            sq87 =  "" + game.getPieceAt(8,7,token) + ".png";
            sq88 =  "" + game.getPieceAt(8,8,token) + ".png";
            sq89 =  "" + game.getPieceAt(8,9,token) + ".png";
            sq810 =  "" + game.getPieceAt(8,10,token) + ".png";
            sq91 =  "" + game.getPieceAt(9,1,token) + ".png";
            sq92 =  "" + game.getPieceAt(9,2,token) + ".png";
            sq93 =  "" + game.getPieceAt(9,3,token) + ".png";
            sq94 =  "" + game.getPieceAt(9,4,token) + ".png";
            sq95 =  "" + game.getPieceAt(9,5,token) + ".png";
            sq96 =  "" + game.getPieceAt(9,6,token) + ".png";
            sq97 =  "" + game.getPieceAt(9,7,token) + ".png";
            sq98 =  "" + game.getPieceAt(9,8,token) + ".png";
            sq99 =  "" + game.getPieceAt(9,9,token) + ".png";
            sq910 =  "" + game.getPieceAt(9,10,token) + ".png";
            sq101 =  "" + game.getPieceAt(10,1,token) + ".png";
            sq102 =  "" + game.getPieceAt(10,2,token) + ".png";
            sq103 =  "" + game.getPieceAt(10,3,token) + ".png";
            sq104 =  "" + game.getPieceAt(10,4,token) + ".png";
            sq105 =  "" + game.getPieceAt(10,5,token) + ".png";
            sq106 =  "" + game.getPieceAt(10,6,token) + ".png";
            sq107 =  "" + game.getPieceAt(10,7,token) + ".png";
            sq108 =  "" + game.getPieceAt(10,8,token) + ".png";
            sq109 =  "" + game.getPieceAt(10,9,token) + ".png";
            sq1010 =  "" + game.getPieceAt(10,10,token) + ".png";
        }
        else if (username.equals(nameTwo))
        {
            col1 = "10";
            col2 = "9";
            col3 = "8";
            col4 = "7";
            col5 = "6";
            col6 = "5";
            col7 = "4";
            col8 = "3";
            col9 = "2";
            col10 = "1";


            row1 = "10";
            row2 = "9";
            row3 = "8";
            row4 = "7";
            row5 = "6";
            row6 = "5";
            row7 = "4";
            row8 = "3";
            row9 = "2";
            row10 = "1";


            sq1010 = "" + game.getPieceAt(1,1,token) + ".png";
            sq109 = "" + game.getPieceAt(1,2,token) + ".png";
            sq108 =  "" + game.getPieceAt(1,3,token) + ".png";
            sq107 =  "" + game.getPieceAt(1,4,token) + ".png";
            sq106 =  "" + game.getPieceAt(1,5,token) + ".png";
            sq105 =  "" + game.getPieceAt(1,6,token) + ".png";
            sq104 =  "" + game.getPieceAt(1,7,token) + ".png";
            sq103 =  "" + game.getPieceAt(1,8,token) + ".png";
            sq102 =  "" + game.getPieceAt(1,9,token) + ".png";
            sq101 =  "" + game.getPieceAt(1,10,token) + ".png";
            sq910 =  "" + game.getPieceAt(2,1,token) + ".png";
            sq99 =  "" + game.getPieceAt(2,2,token) + ".png";
            sq98 =  "" + game.getPieceAt(2,3,token) + ".png";
            sq97 =  "" + game.getPieceAt(2,4,token) + ".png";
            sq96 =  "" + game.getPieceAt(2,5,token) + ".png";
            sq95 =  "" + game.getPieceAt(2,6,token) + ".png";
            sq94 =  "" + game.getPieceAt(2,7,token) + ".png";
            sq93 =  "" + game.getPieceAt(2,8,token) + ".png";
            sq92 =  "" + game.getPieceAt(2,9,token) + ".png";
            sq91 =  "" + game.getPieceAt(2,10,token) + ".png";
            sq810 =  "" + game.getPieceAt(3,1,token) + ".png";
            sq89 =  "" + game.getPieceAt(3,2,token) + ".png";
            sq88 =  "" + game.getPieceAt(3,3,token) + ".png";
            sq87 =  "" + game.getPieceAt(3,4,token) + ".png";
            sq86 =  "" + game.getPieceAt(3,5,token) + ".png";
            sq85 =  "" + game.getPieceAt(3,6,token) + ".png";
            sq84 =  "" + game.getPieceAt(3,7,token) + ".png";
            sq83 =  "" + game.getPieceAt(3,8,token) + ".png";
            sq82 =  "" + game.getPieceAt(3,9,token) + ".png";
            sq81 =  "" + game.getPieceAt(3,10,token) + ".png";
            sq710 =  "" + game.getPieceAt(4,1,token) + ".png";
            sq79 =  "" + game.getPieceAt(4,2,token) + ".png";
            sq78 =  "" + game.getPieceAt(4,3,token) + ".png";
            sq77 =  "" + game.getPieceAt(4,4,token) + ".png";
            sq76 =  "" + game.getPieceAt(4,5,token) + ".png";
            sq75 =  "" + game.getPieceAt(4,6,token) + ".png";
            sq74 =  "" + game.getPieceAt(4,7,token) + ".png";
            sq73 =  "" + game.getPieceAt(4,8,token) + ".png";
            sq72 =  "" + game.getPieceAt(4,9,token) + ".png";
            sq71 =  "" + game.getPieceAt(4,10,token) + ".png";
            sq610 =  "" + game.getPieceAt(5,1,token) + ".png";
            sq69 =  "" + game.getPieceAt(5,2,token) + ".png";
            sq68 =  "" + game.getPieceAt(5,3,token) + ".png";
            sq67 =  "" + game.getPieceAt(5,4,token) + ".png";
            sq66 =  "" + game.getPieceAt(5,5,token) + ".png";
            sq65 =  "" + game.getPieceAt(5,6,token) + ".png";
            sq64 =  "" + game.getPieceAt(5,7,token) + ".png";
            sq63 =  "" + game.getPieceAt(5,8,token) + ".png";
            sq62 =  "" + game.getPieceAt(5,9,token) + ".png";
            sq61 =  "" + game.getPieceAt(5,10,token) + ".png";
            sq510 =  "" + game.getPieceAt(6,1,token) + ".png";
            sq59 =  "" + game.getPieceAt(6,2,token) + ".png";
            sq58 =  "" + game.getPieceAt(6,3,token) + ".png";
            sq57 =  "" + game.getPieceAt(6,4,token) + ".png";
            sq56 =  "" + game.getPieceAt(6,5,token) + ".png";
            sq55 =  "" + game.getPieceAt(6,6,token) + ".png";
            sq54 =  "" + game.getPieceAt(6,7,token) + ".png";
            sq53 =  "" + game.getPieceAt(6,8,token) + ".png";
            sq52 =  "" + game.getPieceAt(6,9,token) + ".png";
            sq51 =  "" + game.getPieceAt(6,10,token) + ".png";
            sq410 =  "" + game.getPieceAt(7,1,token) + ".png";
            sq49 =  "" + game.getPieceAt(7,2,token) + ".png";
            sq48 =  "" + game.getPieceAt(7,3,token) + ".png";
            sq47 =  "" + game.getPieceAt(7,4,token) + ".png";
            sq46 =  "" + game.getPieceAt(7,5,token) + ".png";
            sq45 =  "" + game.getPieceAt(7,6,token) + ".png";
            sq44 =  "" + game.getPieceAt(7,7,token) + ".png";
            sq43 =  "" + game.getPieceAt(7,8,token) + ".png";
            sq42 =  "" + game.getPieceAt(7,9,token) + ".png";
            sq41 =  "" + game.getPieceAt(7,10,token) + ".png";
            sq310 =  "" + game.getPieceAt(8,1,token) + ".png";
            sq39 =  "" + game.getPieceAt(8,2,token) + ".png";
            sq38 =  "" + game.getPieceAt(8,3,token) + ".png";
            sq37 =  "" + game.getPieceAt(8,4,token) + ".png";
            sq36 =  "" + game.getPieceAt(8,5,token) + ".png";
            sq35 =  "" + game.getPieceAt(8,6,token) + ".png";
            sq34 =  "" + game.getPieceAt(8,7,token) + ".png";
            sq33 =  "" + game.getPieceAt(8,8,token) + ".png";
            sq32 =  "" + game.getPieceAt(8,9,token) + ".png";
            sq31 =  "" + game.getPieceAt(8,10,token) + ".png";
            sq210 =  "" + game.getPieceAt(9,1,token) + ".png";
            sq29 =  "" + game.getPieceAt(9,2,token) + ".png";
            sq28 =  "" + game.getPieceAt(9,3,token) + ".png";
            sq27 =  "" + game.getPieceAt(9,4,token) + ".png";
            sq26 =  "" + game.getPieceAt(9,5,token) + ".png";
            sq25 =  "" + game.getPieceAt(9,6,token) + ".png";
            sq24 =  "" + game.getPieceAt(9,7,token) + ".png";
            sq23 =  "" + game.getPieceAt(9,8,token) + ".png";
            sq22 =  "" + game.getPieceAt(9,9,token) + ".png";
            sq21 =  "" + game.getPieceAt(9,10,token) + ".png";
            sq110 =  "" + game.getPieceAt(10,1,token) + ".png";
            sq19 =  "" + game.getPieceAt(10,2,token) + ".png";
            sq18 =  "" + game.getPieceAt(10,3,token) + ".png";
            sq17 =  "" + game.getPieceAt(10,4,token) + ".png";
            sq16 =  "" + game.getPieceAt(10,5,token) + ".png";
            sq15 =  "" + game.getPieceAt(10,6,token) + ".png";
            sq14 =  "" + game.getPieceAt(10,7,token) + ".png";
            sq13 =  "" + game.getPieceAt(10,8,token) + ".png";
            sq12 =  "" + game.getPieceAt(10,9,token) + ".png";
            sq11 =  "" + game.getPieceAt(10,10,token) + ".png";
        }

        availablePieces = new ArrayList<String>();

        List<Piece> pieces = game.getAvailablePlayerPieces(token);

        piecesLength = 0;
        for (Piece piece : pieces)
        {
            piecesLength++;
            availablePieces.add(piece.getType());
        }
    }

    public List<String> getAvailablePieces()
    {
        return availablePieces;
    }

    public int getPiecesLength()
    {
        return piecesLength;
    }

    public String getRow1() { return row1; }
    public String getRow2() { return row2; }
    public String getRow3() { return row3; }
    public String getRow4() { return row4; }
    public String getRow5() { return row5; }
    public String getRow6() { return row6; }
    public String getRow7() { return row7; }
    public String getRow8() { return row8; }
    public String getRow9() { return row9; }
    public String getRow10() { return row10; }

    public String getCol1() { return col1; }
    public String getCol2() { return col2; }
    public String getCol3() { return col3; }
    public String getCol4() { return col4; }
    public String getCol5() { return col5; }
    public String getCol6() { return col6; }
    public String getCol7() { return col7; }
    public String getCol8() { return col8; }
    public String getCol9() { return col9; }
    public String getCol10() { return col10; }


    public String getSq11()
    {
        return sq11;
    }

    public String getSq12() {
        return sq12;
    }

    public String getSq13() {
        return sq13;
    }

    public String getSq14() {
        return sq14;
    }

    public String getSq15() {
        return sq15;
    }

    public String getSq16() {
        return sq16;
    }

    public String getSq17() {
        return sq17;
    }

    public String getSq18() {
        return sq18;
    }

    public String getSq19() {
        return sq19;
    }

    public String getSq110() {
        return sq110;
    }



    public String getSq21()
    {
        return sq21;
    }

    public String getSq22() {
        return sq22;
    }

    public String getSq23() {
        return sq23;
    }

    public String getSq24() {
        return sq24;
    }

    public String getSq25() {
        return sq25;
    }

    public String getSq26() {
        return sq26;
    }

    public String getSq27() {
        return sq27;
    }

    public String getSq28() {
        return sq28;
    }

    public String getSq29() {
        return sq29;
    }

    public String getSq210() {
        return sq210;
    }




    public String getSq31()
    {
        return sq31;
    }

    public String getSq32() {
        return sq32;
    }

    public String getSq33() {
        return sq33;
    }

    public String getSq34() {
        return sq34;
    }

    public String getSq35() {
        return sq35;
    }

    public String getSq36() {
        return sq36;
    }

    public String getSq37() {
        return sq37;
    }

    public String getSq38() {
        return sq38;
    }

    public String getSq39() {
        return sq39;
    }

    public String getSq310() {
        return sq310;
    }



    public String getSq41()
    {
        return sq41;
    }

    public String getSq42() {
        return sq42;
    }

    public String getSq43() {
        return sq43;
    }

    public String getSq44() {
        return sq44;
    }

    public String getSq45() {
        return sq45;
    }

    public String getSq46() {
        return sq46;
    }

    public String getSq47() {
        return sq47;
    }

    public String getSq48() {
        return sq48;
    }

    public String getSq49() {
        return sq49;
    }

    public String getSq410() {
        return sq410;
    }



    public String getSq51()
    {
        return sq51;
    }

    public String getSq52() {
        return sq52;
    }

    public String getSq53() {
        return sq53;
    }

    public String getSq54() {
        return sq54;
    }

    public String getSq55() {
        return sq55;
    }

    public String getSq56() {
        return sq56;
    }

    public String getSq57() {
        return sq57;
    }

    public String getSq58() {
        return sq58;
    }

    public String getSq59() {
        return sq59;
    }

    public String getSq510() {
        return sq510;
    }




    public String getSq61()
    {
        return sq61;
    }

    public String getSq62() {
        return sq62;
    }

    public String getSq63() {
        return sq63;
    }

    public String getSq64() {
        return sq64;
    }

    public String getSq65() {
        return sq65;
    }

    public String getSq66() {
        return sq66;
    }

    public String getSq67() {
        return sq67;
    }

    public String getSq68() {
        return sq68;
    }

    public String getSq69() {
        return sq69;
    }

    public String getSq610() {
        return sq610;
    }



    public String getSq71()
    {
        return sq71;
    }

    public String getSq72() {
        return sq72;
    }

    public String getSq73() {
        return sq73;
    }

    public String getSq74() {
        return sq74;
    }

    public String getSq75() {
        return sq75;
    }

    public String getSq76() {
        return sq76;
    }

    public String getSq77() {
        return sq77;
    }

    public String getSq78() {
        return sq78;
    }

    public String getSq79() {
        return sq79;
    }

    public String getSq710() {
        return sq710;
    }




    public String getSq81()
    {
        return sq81;
    }

    public String getSq82() {
        return sq82;
    }

    public String getSq83() {
        return sq83;
    }

    public String getSq84() {
        return sq84;
    }

    public String getSq85() {
        return sq85;
    }

    public String getSq86() {
        return sq86;
    }

    public String getSq87() {
        return sq87;
    }

    public String getSq88() {
        return sq88;
    }

    public String getSq89() {
        return sq89;
    }

    public String getSq810() {
        return sq810;
    }




    public String getSq91()
    {
        return sq91;
    }

    public String getSq92() {
        return sq92;
    }

    public String getSq93() {
        return sq93;
    }

    public String getSq94() {
        return sq94;
    }

    public String getSq95() {
        return sq95;
    }

    public String getSq96() {
        return sq96;
    }

    public String getSq97() {
        return sq97;
    }

    public String getSq98() {
        return sq98;
    }

    public String getSq99() {
        return sq99;
    }

    public String getSq910() {
        return sq910;
    }



    public String getSq101()
    {
        return sq101;
    }

    public String getSq102() {
        return sq102;
    }

    public String getSq103() {
        return sq103;
    }

    public String getSq104() {
        return sq104;
    }

    public String getSq105() {
        return sq105;
    }

    public String getSq106() {
        return sq106;
    }

    public String getSq107() {
        return sq107;
    }

    public String getSq108() {
        return sq108;
    }

    public String getSq109() {
        return sq109;
    }

    public String getSq1010() {
        return sq1010;
    }
}
