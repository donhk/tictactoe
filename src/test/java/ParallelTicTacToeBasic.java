/*
 * @author donhk
 * 08/02/20
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParallelTicTacToeBasic {

    //invalid inputs
    @Test
    public void invalidInputNull() {
        //invalid input, board input does not match board criteria
        assertEquals(Evaluation.InvalidInput, ParallelTicTacToe.evaluateBoard(null));
    }

    @Test
    public void invalidInputLargerBoard() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.InvalidInput, ParallelTicTacToe.evaluateBoard("XOXOXOXOXXX"));
    }

    @Test
    public void invalidInputSmallerBoard() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.InvalidInput, ParallelTicTacToe.evaluateBoard("XX"));
    }

    @Test
    public void invalidInputNoBoard() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.InvalidInput, ParallelTicTacToe.evaluateBoard(""));
    }

    //unreachable state
    @Test
    public void unreachableStateMoreO() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, ParallelTicTacToe.evaluateBoard("OOOOXXOOO"));
    }

    @Test
    public void unreachableStateAllO() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, ParallelTicTacToe.evaluateBoard("OOOOOOOOO"));
    }

    @Test
    public void unreachableStateAllX() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, ParallelTicTacToe.evaluateBoard("XXXXXXXXX"));
    }

    @Test
    public void unreachableStateMoreX() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, ParallelTicTacToe.evaluateBoard("XXXXXOOXX"));
    }

    @Test
    public void unreachableStateNoO() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, ParallelTicTacToe.evaluateBoard("XXX......"));
    }

    @Test
    public void unreachableStateNoX() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.UnreachableState, ParallelTicTacToe.evaluateBoard("OOO......"));
    }

    //no winner
    @Test
    public void simpleNoWinnerBoard() {
        assertEquals(Evaluation.NoWinner, ParallelTicTacToe.evaluateBoard("O...X.X.."));
    }

    @Test
    public void noWinnerFullBoard() {
        //assertEquals(Evaluation.NoWinner, ParallelTicTacToe.evaluateBoard("XOXOXOXOX"));//TODO valid?
    }

    @Test
    public void noWinnerEmpty() {
        //invalid input, board input does not fit board criteria
        assertEquals(Evaluation.NoWinner, ParallelTicTacToe.evaluateBoard("........."));
    }

    //x wins horizontal
    @Test
    public void xWinsHorizontalRow1() {
        assertEquals(Evaluation.Xwins, ParallelTicTacToe.evaluateBoard("XXX.O.O.."));
    }

    @Test
    public void xWinsHorizontalRow2() {
        assertEquals(Evaluation.Xwins, ParallelTicTacToe.evaluateBoard(".O.XXX.O."));
    }

    @Test
    public void xWinsHorizontalRow3() {
        assertEquals(Evaluation.Xwins, ParallelTicTacToe.evaluateBoard(".OO...XXX"));
    }

    //x wins vertical
    @Test
    public void xWinsVerticalColumn1() {
        assertEquals(Evaluation.Xwins, ParallelTicTacToe.evaluateBoard("X..XO.XO."));
    }

    @Test
    public void xWinsVerticalColumn2() {
        assertEquals(Evaluation.Xwins, ParallelTicTacToe.evaluateBoard("OX..X..XO"));
    }

    @Test
    public void xWinsVerticalColumn3() {
        assertEquals(Evaluation.Xwins, ParallelTicTacToe.evaluateBoard("..XO.X.OX"));
    }

    //x wins diagonal
    @Test
    public void xWinsDiagonalTiltLeft() {
        assertEquals(Evaluation.Xwins, ParallelTicTacToe.evaluateBoard("XO..X.O.X"));
    }

    @Test
    public void xWinsDiagonalTiltRight() {
        assertEquals(Evaluation.Xwins, ParallelTicTacToe.evaluateBoard(".OX.X.XO."));
    }

    //o wins horizontal
    @Test
    public void oWinsHorizontalRow1() {
        assertEquals(Evaluation.Owins, ParallelTicTacToe.evaluateBoard("OOO.X.XX."));
    }

    @Test
    public void oWinsHorizontalRow2() {
        assertEquals(Evaluation.Owins, ParallelTicTacToe.evaluateBoard("..XOOOXX."));
    }

    @Test
    public void oWinsHorizontalRow3() {
        assertEquals(Evaluation.Owins, ParallelTicTacToe.evaluateBoard(".X.X.XOOO"));
    }

    //o wins vertical
    @Test
    public void oWinsVerticalColumn1() {
        assertEquals(Evaluation.Owins, ParallelTicTacToe.evaluateBoard("O.XOX.O.X"));
    }

    @Test
    public void oWinsVerticalColumn2() {
        assertEquals(Evaluation.Owins, ParallelTicTacToe.evaluateBoard("XOX.O..OX"));
    }

    @Test
    public void oWinsVerticalColumn3() {
        assertEquals(Evaluation.Owins, ParallelTicTacToe.evaluateBoard("XXO..O.XO"));
    }

    //o wins diagonal
    @Test
    public void oWinsDiagonalTiltLeft() {
        /*
            O X X
            _ O _
            _ X O
         */
        assertEquals(Evaluation.Owins, ParallelTicTacToe.evaluateBoard("OXX.O..XO"));
    }

    @Test
    public void oWinsDiagonalTiltRight() {
        assertEquals(Evaluation.Owins, ParallelTicTacToe.evaluateBoard(".XO.O.OXX"));
    }

}