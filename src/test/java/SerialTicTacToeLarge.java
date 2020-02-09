/*
 * @author donhk
 * 08/02/20
 */

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

public class SerialTicTacToeLarge {
    @Test
    public void SerialLongHorizontal() {
        final int boardSize = 1_000;
        final BoardGenerator generator = BoardGenerator.newInstance(boardSize);
        final LocalDateTime boardCreation = LocalDateTime.now();
        System.out.println("Preparing board of " + boardSize + " rows");
        final String input = generator.generateHorizontalWinner();
        System.out.printf("Board prepared in [%d]\n", (boardCreation.until(LocalDateTime.now(), ChronoUnit.SECONDS)));
        final LocalDateTime algoStart = LocalDateTime.now();
        assertEquals(Evaluation.Xwins, SerialTicTacToe.evaluateBoard(input));
        System.out.printf("rows [%d] cells [%d] seconds [%d]\n", boardSize, ((int) Math.pow(boardSize, 2)), (algoStart.until(LocalDateTime.now(), ChronoUnit.SECONDS)));
    }
}
