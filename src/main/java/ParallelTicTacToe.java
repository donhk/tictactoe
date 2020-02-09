import java.util.concurrent.*;

/*
 * @author donhk
 * 08/02/20
 */
public class ParallelTicTacToe {
    private enum CallType {V, H, LD, RD}

    public static Evaluation evaluateBoard(String boardState) {
        //check for invalid input
        final Wrapper wrapper = validateBoard(boardState);
        if (wrapper.evaluation == Evaluation.UnreachableState ||
                wrapper.evaluation == Evaluation.InvalidInput) {
            return wrapper.evaluation;
        }
        final int diagonalSize = wrapper.diagonal;
        final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        final CompletionService<Evaluation> completionService = new ExecutorCompletionService<>(executorService);
        completionService.submit(new Worker(wrapper.string, diagonalSize, CallType.H));
        completionService.submit(new Worker(wrapper.string, diagonalSize, CallType.V));
        completionService.submit(new Worker(wrapper.string, diagonalSize, CallType.LD));
        completionService.submit(new Worker(wrapper.string, diagonalSize, CallType.RD));
        for (int i = 0; i < 4; i++) {
            try {
                Evaluation evaluation = completionService.take().get();
                if (evaluation == Evaluation.Owins || evaluation == Evaluation.Xwins) {
                    executorService.shutdownNow();
                    return evaluation;
                }
            } catch (Exception ignored) {
            }
        }
        return Evaluation.NoWinner;
    }

    private static Evaluation checkDiagonalWin(String boardState, int diagonalSize) {
        int perfectMatch = 0;
        char c = '!';
        final int leftDelta = diagonalSize + 1;
        int leftPosition = 0;
        for (int i = 1; i <= diagonalSize; i++) {
            char tmpChar = boardState.charAt(leftPosition);
            if (c == '!') {
                if (tmpChar == '.') {
                    break;
                }
                c = tmpChar;
                perfectMatch++;
            } else {
                if (tmpChar == '.') {
                    return Evaluation.NoWinner;
                } else if (c == tmpChar) {
                    perfectMatch++;
                } else {
                    return Evaluation.NoWinner;
                }
            }
            leftPosition += leftDelta;
        }
        if (perfectMatch == diagonalSize) {
            if (c == 'x') {
                return Evaluation.Xwins;
            }
            return Evaluation.Owins;
        }

        perfectMatch = 0;
        c = '!';
        final int rightDelta = diagonalSize - 1;
        int rightIndex = diagonalSize - 1;
        for (int i = 1; i <= diagonalSize; i++) {
            char tmpChar = boardState.charAt(rightIndex);
            if (c == '!') {
                if (tmpChar == '.') {
                    return Evaluation.NoWinner;
                }
                c = tmpChar;
                perfectMatch++;
            } else {
                if (tmpChar == '.') {
                    return Evaluation.NoWinner;
                } else if (c == tmpChar) {
                    perfectMatch++;
                } else {
                    return Evaluation.NoWinner;
                }
            }
            rightIndex += rightDelta;
        }
        if (perfectMatch == diagonalSize) {
            if (c == 'x') {
                return Evaluation.Xwins;
            }
            return Evaluation.Owins;
        }
        return Evaluation.NoWinner;
    }

    private static Wrapper validateBoard(String board) {
        final Wrapper p = new Wrapper();
        if (board == null || board.equals("")) {
            p.evaluation = Evaluation.InvalidInput;
            return p;
        }
        final double diagonalSize = Math.sqrt(board.length());
        final int half = board.length() / 2;
        final int size = (int) diagonalSize;
        final double leftOver = diagonalSize - size;
        if (leftOver != 0) {
            p.evaluation = Evaluation.InvalidInput;
            return p;
        }

        final StringBuilder sb = new StringBuilder();
        int xHits = 0;
        int oHits = 0;
        int index = 0;
        for (char c : board.toCharArray()) {
            index++;
            if (c == 'x' || c == 'X') {
                sb.append('x');
                xHits++;
            } else if (c == 'o' || c == 'O') {
                sb.append('o');
                oHits++;
            } else {
                sb.append('.');
            }
            if (index > half) {
                if (xHits > index || oHits > index) {
                    p.evaluation = Evaluation.UnreachableState;
                    return p;
                }
            }
        }
        final int diff = Math.abs(xHits - oHits);
        if (diff > 1) {
            p.evaluation = Evaluation.UnreachableState;
            return p;
        }
        p.diagonal = size;
        p.string = sb.toString();
        return p;
    }

    private static class Wrapper {
        Evaluation evaluation = Evaluation.NoWinner;
        String string;
        int diagonal;
    }

    private static class Worker implements Callable<Evaluation> {
        private final String board;
        private final int diagonalSize;
        private final CallType type;

        Worker(String board, int diagonalSize, CallType type) {
            this.board = board;
            this.diagonalSize = diagonalSize;
            this.type = type;
        }

        @Override
        public Evaluation call() {
            switch (type) {
                case V:
                    return vertical();
                case H:
                    return horizontal();
                case LD:
                    return leftDiagonal();
                case RD:
                    return rightDiagonal();
            }
            return Evaluation.UnreachableState;
        }

        private Evaluation vertical() {
            return verticalWin(board, diagonalSize);
        }

        private Evaluation horizontal() {
            return horizontalWin(board, diagonalSize);
        }

        private Evaluation leftDiagonal() {
            int perfectMatch = 0;
            char c = '!';
            final int leftDelta = diagonalSize + 1;
            int leftPosition = 0;
            for (int i = 1; i <= diagonalSize; i++) {
                char tmpChar = board.charAt(leftPosition);
                if (c == '!') {
                    if (tmpChar == '.') {
                        break;
                    }
                    c = tmpChar;
                    perfectMatch++;
                } else {
                    if (tmpChar == '.') {
                        return Evaluation.NoWinner;
                    } else if (c == tmpChar) {
                        perfectMatch++;
                    } else {
                        return Evaluation.NoWinner;
                    }
                }
                leftPosition += leftDelta;
            }
            if (perfectMatch == diagonalSize) {
                if (c == 'x') {
                    return Evaluation.Xwins;
                }
                return Evaluation.Owins;
            }
            return Evaluation.NoWinner;
        }

        private Evaluation rightDiagonal() {
            int perfectMatch = 0;
            char c = '!';
            final int rightDelta = diagonalSize - 1;
            int rightIndex = diagonalSize - 1;
            for (int i = 1; i <= diagonalSize; i++) {
                char tmpChar = board.charAt(rightIndex);
                if (c == '!') {
                    if (tmpChar == '.') {
                        return Evaluation.NoWinner;
                    }
                    c = tmpChar;
                    perfectMatch++;
                } else {
                    if (tmpChar == '.') {
                        return Evaluation.NoWinner;
                    } else if (c == tmpChar) {
                        perfectMatch++;
                    } else {
                        return Evaluation.NoWinner;
                    }
                }
                rightIndex += rightDelta;
            }
            if (perfectMatch == diagonalSize) {
                if (c == 'x') {
                    return Evaluation.Xwins;
                }
                return Evaluation.Owins;
            }
            return Evaluation.NoWinner;
        }

        private static Evaluation verticalWin(String board, int diagonalSize) {
            for (int col = 1; col <= diagonalSize; col++) {
                final char c = board.charAt(col - 1);
                if (c == '.') {
                    continue;
                }
                int perfectMatch = 1;
                for (int row = diagonalSize + col; row <= board.length(); row += diagonalSize) {
                    final char cc = board.charAt(row - 1);
                    if (c == cc) {
                        perfectMatch++;
                        if (perfectMatch == diagonalSize) {
                            if (c == 'x') {
                                return Evaluation.Xwins;
                            }
                            return Evaluation.Owins;
                        }
                    } else {
                        break;
                    }
                }
            }
            return Evaluation.NoWinner;
        }

        private static Evaluation horizontalWin(String board, int diagonalSize) {
            //look for horizontal winners
            int perfectMatch = 0;
            char reference = '!';
            int rowRemaining = 0;
            for (int cell = 0; cell < board.length(); cell++) {
                final char c = board.charAt(cell);
                if (rowRemaining == 0) {
                    rowRemaining = diagonalSize - 1;
                }
                if (reference == '!') {
                    if (c == '.') {
                        cell += rowRemaining;
                        reference = '!';
                        perfectMatch = 0;
                        rowRemaining = 0;
                        continue;
                    } else {
                        reference = c;
                        perfectMatch++;
                    }
                } else {
                    if (reference == c) {
                        perfectMatch++;
                        if (perfectMatch == diagonalSize) {
                            if (reference == 'x') {
                                return Evaluation.Xwins;
                            }
                            return Evaluation.Owins;
                        }
                    } else {
                        cell += rowRemaining;
                        reference = '!';
                        perfectMatch = 0;
                        rowRemaining = 0;
                        continue;
                    }
                }
                rowRemaining--;
            }
            return Evaluation.NoWinner;
        }
    }
}
