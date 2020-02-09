import org.junit.Test;

public class FileBoardTicTacToe {
    @Test
    public void SuperLargeSet() {
        final BoardGenerator generator = BoardGenerator.newInstance(5);
        generator.generateHorizontalWinner("simple_board.log");
    }
}
