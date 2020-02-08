/*
 * @author donhk
 * 08/02/20
 */

import org.junit.Test;

public class SerialTicTacToeLarge {
    @Test
    public void createLargeSet() {
        final BoardGenerator generator = BoardGenerator.newInstance(3);
        //generator.generateRandomBoard();
        generator.generateLeftDiagonalWinner();
        generator.generateRightDiagonalWinner();
    }
}
