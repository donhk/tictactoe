/**
 * @author donhk
 * 08/02/20
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SerialTicTacToeTest {

    //invalid inputs
    @Test
    public void invalidInputNull() {
        //invalid input, board input does not match board criteria
        assertEquals(Evaluation.InvalidInput, SerialTicTacToe.evaluateBoard(null));
    }

    @Test
    public void invalidInputLargerBoard() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.InvalidInput, SerialTicTacToe.evaluateBoard("XOXOXOXOXXX"));
    }

    @Test
    public void invalidInputSmallerBoard() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.InvalidInput, SerialTicTacToe.evaluateBoard("XX"));
    }

    @Test
    public void invalidInputNoBoard() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.InvalidInput, SerialTicTacToe.evaluateBoard(""));
    }

    //unreachable state
    @Test
    public void unreachableStateMoreO() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, SerialTicTacToe.evaluateBoard("OOOOXXOOO"));
    }

    @Test
    public void unreachableStateAllO() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, SerialTicTacToe.evaluateBoard("OOOOOOOOO"));
    }

    @Test
    public void unreachableStateAllX() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, SerialTicTacToe.evaluateBoard("XXXXXXXXX"));
    }

    @Test
    public void unreachableStateMoreX() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, SerialTicTacToe.evaluateBoard("XXXXXOOXX"));
    }

    @Test
    public void unreachableStateNoO() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, SerialTicTacToe.evaluateBoard("XXX......"));
    }

    @Test
    public void unreachableStateNoX() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, SerialTicTacToe.evaluateBoard("OOO......"));
    }

    //no winner
    @Test
    public void simpleNoWinnerBoard() {
        assertEquals(Evaluation.NoWinner, SerialTicTacToe.evaluateBoard("O...X.X.."));
    }

    @Test
    public void noWinnerFullBoard() {
        //assertEquals(Evaluation.NoWinner, SerialTicTacToe.evaluateBoard("XOXOXOXOX"));//TODO valid?
    }

    @Test
    public void noWinnerEmpty() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.NoWinner, SerialTicTacToe.evaluateBoard("........."));
    }

    //x wins horizontal
    @Test
    public void xWinsHorizontalRow1() {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard("XXX.O.O.."));
    }

    @Test
    public void xWinsHorizontalRow2() {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard(".O.XXX.O."));
    }

    @Test
    public void xWinsHorizontalRow3() {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard(".OO...XXX"));
    }

    //x wins vertical
    @Test
    public void xWinsVerticalColumn1() {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard("X..XO.XO."));
    }

    @Test
    public void xWinsVerticalColumn2() {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard("OX..X..XO"));
    }

    @Test
    public void xWinsVerticalColumn3() {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard("..XO.X.OX"));
    }

    //x wins diagonal
    @Test
    public void xWinsDiagonalTiltLeft() {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard("XO..X.O.X"));
    }

    @Test
    public void xWinsDiagonalTiltRight() {
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard(".OX.X.XO."));
    }

    //o wins horizontal
    @Test
    public void oWinsHorizontalRow1() {
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard("OOO.X.XX."));
    }

    @Test
    public void oWinsHorizontalRow2() {
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard("..XOOOXX."));
    }

    @Test
    public void oWinsHorizontalRow3() {
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard(".X.X.XOOO"));
    }

    //o wins vertical
    @Test
    public void oWinsVerticalColumn1() {
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard("O.XOX.O.X"));
    }

    @Test
    public void oWinsVerticalColumn2() {
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard("XOX.O..OX"));
    }

    @Test
    public void oWinsVerticalColumn3() {
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard("XXO..O.XO"));
    }

    //o wins diagonal
    @Test
    public void oWinsDiagonalTiltLeft() {
        /*
            O X X
            _ O _
            _ X O
         */
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard("OXX.O..XO"));
    }

    @Test
    public void oWinsDiagonalTiltRight() {
        assertEquals(Evaluation.Owins, SerialTicTacToe.evaluateBoard(".XO.O.OXX"));
    }

}