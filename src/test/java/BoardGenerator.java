import java.util.Random;

public class BoardGenerator {
    private final int size;
    private final Random random = new Random();

    private enum WinnerType {H, V, LD, RD}

    private BoardGenerator(int size) {
        this.size = size;
    }

    public static BoardGenerator newInstance(int size) {
        return new BoardGenerator(size);
    }

    public String generateRandomBoard() {
        final StringBuilder sb = new StringBuilder();
        int xHints = 0;
        int oHints = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final char c = play();
                if (c == 'x') {
                    xHints++;
                } else {
                    oHints++;
                }
                if (Math.abs(xHints - oHints) < 1) {
                    sb.append(".");
                } else {
                    sb.append(c);
                }

            }
        }
        return sb.toString();
    }

    public String generateHorizontalWinner() {
        return createBoard(WinnerType.H);
    }

    public String generateVerticalWinner() {
        return createBoard(WinnerType.V);
    }

    public String generateLeftDiagonalWinner() {
        final StringBuilder sb = new StringBuilder();
        final Character[][] board = new Character[size][size];
        //fill with empty
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '.';
            }
        }

        //insert n random loser marks
        for (int lInsert = 0; lInsert < (size + 1); lInsert++) {
            final Point p = getCord();
            board[p.x][p.y] = 'o';
        }
        //insert winner marks
        for (int wx = 0; wx < size; wx++) {
            board[wx][wx] = 'x';
        }
        //get final board
        for (int cellX = 0; cellX < size; cellX++) {
            for (int cellY = 0; cellY < size; cellY++) {
                System.out.print(board[cellX][cellY] + "|");
                sb.append(board[cellX][cellY]);
            }
            System.out.println();
        }
        return sb.toString();
    }

    public String generateRightDiagonalWinner() {
        final StringBuilder sb = new StringBuilder();
        final Character[][] board = new Character[size][size];
        //fill with empty
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '.';
            }
        }

        //insert n random loser marks
        for (int lInsert = 0; lInsert < (size + 1); lInsert++) {
            final Point p = getCord();
            board[p.x][p.y] = 'o';
        }
        //insert winner marks
        for (int wx = 0; wx < size; wx++) {
            board[wx][wx] = 'x';
        }
        //get final board
        for (int cellX = 0; cellX < size; cellX++) {
            for (int cellY = 0; cellY < size; cellY++) {
                System.out.print(board[cellX][cellY] + "|");
                sb.append(board[cellX][cellY]);
            }
            System.out.println();
        }
        return sb.toString();
    }

    private String createBoard(WinnerType type) {
        final StringBuilder sb = new StringBuilder();
        final Character[][] board = new Character[size][size];
        //fill with empty
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '.';
            }
        }
        final int wj = random.nextInt(size);
        //insert n random loser marks
        for (int lInsert = 0; lInsert < (size + 1); lInsert++) {
            final int i = getCord(wj);
            final int j = getCord(wj);
            board[i][j] = 'o';
        }
        //insert winner marks
        for (int wx = 0; wx < size; wx++) {
            switch (type) {
                case H:
                    board[wj][wx] = 'x';
                    break;
                case V:
                    board[wx][wj] = 'x';
                    break;
            }
        }
        //get final board
        for (int cellX = 0; cellX < size; cellX++) {
            for (int cellY = 0; cellY < size; cellY++) {
                System.out.print(board[cellX][cellY] + "|");
                sb.append(board[cellX][cellY]);
            }
            System.out.println();
        }
        return sb.toString();
    }

    /**
     * Get random turn
     *
     * @return x or o
     */
    private char play() {
        final int opc = random.nextInt(4);
        if (opc > 1) {
            return 'o';
        }
        return 'X';
    }

    /**
     * gets a random number between 0 and size but preventing
     * collisions to ensure the relation between the
     * loser and the winner turns are always lees than 1
     *
     * @param reservedNumber number to skip
     * @return random number
     */
    private int getCord(int reservedNumber) {
        int opc = random.nextInt(size);
        while (opc == reservedNumber) {
            opc = random.nextInt(size);
        }
        return opc;
    }

    private Point getCord() {
        int opcA = random.nextInt(size);
        int opcB = random.nextInt(size);
        while (opcA == opcB) {
            opcA = random.nextInt(size);
            opcB = random.nextInt(size);
        }
        return new Point(opcA, opcB);
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
