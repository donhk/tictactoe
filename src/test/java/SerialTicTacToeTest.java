import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SerialTicTacToeTest {

    //invalid inputs
    @Test
    public void invalidInputNull() throws Exception {
        //invalid input, board input does not match board criteria
        assertEquals(Evaluation.InvalidInput, SerialTicTacToe.evaluateBoard(null));
    }

    @Test
    public void invalidInputLargerBoard() throws Exception {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.InvalidInput, SerialTicTacToe.evaluateBoard("XOXOXOXOXXX"));
    }

    @Test
    public void invalidInputSmallerBoard() throws Exception {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.InvalidInput, SerialTicTacToe.evaluateBoard("XX"));
    }

    @Test
    public void invalidInputNoBoard() throws Exception {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.InvalidInput, SerialTicTacToe.evaluateBoard(""));
    }

    //unreachable state
    @Test
    public void unreachableStateMoreO() throws Exception {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, SerialTicTacToe.evaluateBoard("OOOOXXOOO"));
    }

    @Test
    public void unreachableStateAllO() throws Exception {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, SerialTicTacToe.evaluateBoard("OOOOOOOOO"));
    }

    @Test
    public void unreachableStateAllX() throws Exception {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, SerialTicTacToe.evaluateBoard("XXXXXXXXX"));
    }

    @Test
    public void unreachableStateMoreX() throws Exception {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, SerialTicTacToe.evaluateBoard("XXXXXOOXX"));
    }

    @Test
    public void unreachableStateNoO() throws Exception {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, SerialTicTacToe.evaluateBoard("XXX......"));
    }

    @Test
    public void unreachableStateNoX() throws Exception {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, SerialTicTacToe.evaluateBoard("OOO......"));
    }

    //no winner
    @Test
    public void simpleNoWinnerBoard() throws Exception {
        assertEquals(Evaluation.NoWinner, SerialTicTacToe.evaluateBoard("O...X.X.."));
    }

    @Test
    public void noWinnerFullBoard() throws Exception {
        assertEquals(Evaluation.NoWinner, SerialTicTacToe.evaluateBoard("XOXOXOXOX"));
    }

    @Test
    public void noWinnerEmpty() throws Exception {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.NoWinner, SerialTicTacToe.evaluateBoard("........."));
    }

    //x wins horizontal
    @Test
    public void xWinsHorizontalRow1() throws Exception {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard("XXX.O.O.."));
    }

    @Test
    public void xWinsHorizontalRow2() throws Exception {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard(".O.XXX.O."));
    }

    @Test
    public void xWinsHorizontalRow3() throws Exception {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard(".OO...XXX"));
    }

    //x wins vertical
    @Test
    public void xWinsVerticalColumn1() throws Exception {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard("X..XO.XO."));
    }

    @Test
    public void xWinsVerticalColumn2() throws Exception {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard("OX..X..XO"));
    }

    @Test
    public void xWinsVerticalColumn3() throws Exception {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard("..XO.X.OX"));
    }

    //x wins diagonal
    @Test
    public void xWinsDiagonalTiltLeft() throws Exception {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard("XO..X.O.X"));
    }

    @Test
    public void xWinsDiagonalTiltRight() throws Exception {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard(".OX.X.XO."));
    }

    //o wins horizontal
    @Test
    public void oWinsHorizontalRow1() throws Exception {
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard("OOO.X.XX."));
    }

    @Test
    public void oWinsHorizontalRow2() throws Exception {
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard("..XOOOXX."));
    }

    @Test
    public void oWinsHorizontalRow3() throws Exception {
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard(".X.X.XOOO"));
    }

    //o wins vertical
    @Test
    public void oWinsVerticalColumn1() throws Exception {
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard("O.XOX.O.X"));
    }

    @Test
    public void oWinsVerticalColumn2() throws Exception {
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard("XOX.O..OX"));
    }

    @Test
    public void oWinsVerticalColumn3() throws Exception {
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard("XXO..O.XO"));
    }

    //o wins diagonal
    @Test
    public void oWinsDiagonalTiltLeft() throws Exception {
        /*
            O X X
            _ O _
            _ X O
         */
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard("OXX.O..XO"));
    }

    @Test
    public void oWinsDiagonalTiltRight() throws Exception {
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard(".XO.O.OXX"));
    }

}