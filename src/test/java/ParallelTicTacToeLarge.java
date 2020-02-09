/*
 * @author donhk
 * 08/02/20
 */

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

public class ParallelTicTacToeLarge {
    private final int boardSize = 25_000;

    @Test
    public void ParallelLongHorizontal() {
        final BoardGenerator generator = BoardGenerator.newInstance(boardSize);
        final LocalDateTime boardCreation = LocalDateTime.now();
        System.out.println("Preparing board of " + boardSize + " rows");
        final String input = generator.generateHorizontalWinner();
        System.out.printf("Board prepared in [%d]\n", (boardCreation.until(LocalDateTime.now(), ChronoUnit.SECONDS)));
        final LocalDateTime algoStart = LocalDateTime.now();
        assertEquals(Evaluation.Xwins, ParallelTicTacToe.evaluateBoard(input));
        System.out.printf("Board evaluated summary | rows [%d] cells [%d] seconds [%d]\n", boardSize, ((int) Math.pow(boardSize, 2)), (algoStart.until(LocalDateTime.now(), ChronoUnit.SECONDS)));
    }

    @Test
    public void ParallelLongVertical() {
        final BoardGenerator generator = BoardGenerator.newInstance(boardSize);
        final LocalDateTime boardCreation = LocalDateTime.now();
        System.out.println("Preparing board of " + boardSize + " rows");
        final String input = generator.generateVerticalWinner();
        System.out.printf("Board prepared in [%d]\n", (boardCreation.until(LocalDateTime.now(), ChronoUnit.SECONDS)));
        final LocalDateTime algoStart = LocalDateTime.now();
        assertEquals(Evaluation.Xwins, ParallelTicTacToe.evaluateBoard(input));
        System.out.printf("Board evaluated summary | rows [%d] cells [%d] seconds [%d]\n", boardSize, ((int) Math.pow(boardSize, 2)), (algoStart.until(LocalDateTime.now(), ChronoUnit.SECONDS)));
    }

    @Test
    public void ParallelLongLeftDiagonal() {
        final BoardGenerator generator = BoardGenerator.newInstance(boardSize);
        final LocalDateTime boardCreation = LocalDateTime.now();
        System.out.println("Preparing board of " + boardSize + " rows");
        final String input = generator.generateLeftDiagonalWinner();
        System.out.printf("Board prepared in [%d]\n", (boardCreation.until(LocalDateTime.now(), ChronoUnit.SECONDS)));
        final LocalDateTime algoStart = LocalDateTime.now();
        assertEquals(Evaluation.Xwins, ParallelTicTacToe.evaluateBoard(input));
        System.out.printf("Board evaluated summary | rows [%d] cells [%d] seconds [%d]\n", boardSize, ((int) Math.pow(boardSize, 2)), (algoStart.until(LocalDateTime.now(), ChronoUnit.SECONDS)));
    }

    @Test
    public void ParallelLongRightDiagonal() {
        final BoardGenerator generator = BoardGenerator.newInstance(boardSize);
        final LocalDateTime boardCreation = LocalDateTime.now();
        System.out.println("Preparing board of " + boardSize + " rows");
        final String input = generator.generateRightDiagonalWinner();
        System.out.printf("Board prepared in [%d]\n", (boardCreation.until(LocalDateTime.now(), ChronoUnit.SECONDS)));
        final LocalDateTime algoStart = LocalDateTime.now();
        assertEquals(Evaluation.Xwins, ParallelTicTacToe.evaluateBoard(input));
        System.out.printf("Board evaluated summary | rows [%d] cells [%d] seconds [%d]\n", boardSize, ((int) Math.pow(boardSize, 2)), (algoStart.until(LocalDateTime.now(), ChronoUnit.SECONDS)));
    }
}
