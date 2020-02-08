public class SerialTicTacToe {

    public static Evaluation evaluateBoard(String boardState) {
        //check for invalid input
        final Parsed p = validateBoard(boardState);
        if (p.evaluation == Evaluation.UnreachableState || p.evaluation == Evaluation.InvalidInput) {
            return p.evaluation;
        }
        final String board = p.string;
        final int diagonalSize = p.diagonal;

        //look for horizontal winners
        final Evaluation horizontalWin = horizontalWin(board, diagonalSize);
        if (horizontalWin != Evaluation.NoWinner) {
            return horizontalWin;
        }
        //look for vertical winners
        final Evaluation verticalWin = verticalWin(board, diagonalSize);
        if (verticalWin != Evaluation.NoWinner) {
            return verticalWin;
        }
        //look for diagonal winners
        return checkDiagonalWin(board, diagonalSize);
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

    private static Evaluation verticalWin(String boardState, int diagonalSize) {
        for (int col = 1; col <= diagonalSize; col++) {
            final char c = boardState.charAt(col - 1);
            if (c == '.') {
                continue;
            }
            int perfectMatch = 1;
            for (int row = diagonalSize + col; row < boardState.length(); row += diagonalSize) {
                final char cc = boardState.charAt(row - 1);
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
        for (int x1 = 0; x1 < board.length(); x1++) {
            if (rowRemaining == 0) {
                rowRemaining = diagonalSize - 1;
            }
            final char c = board.charAt(x1);
            rowRemaining--;
            if (c == '.') {
                x1 += rowRemaining;
                reference = '!';
                perfectMatch = 0;
                continue;
            }
            if (reference == '!') {
                reference = c;
                perfectMatch++;
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
                    x1 += rowRemaining;
                    reference = '!';
                    perfectMatch = 0;
                }
            }
        }
        return Evaluation.NoWinner;
    }

    private static Parsed validateBoard(String board) {
        final Parsed p = new Parsed();
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

    private static class Parsed {
        Evaluation evaluation = Evaluation.NoWinner;
        String string;
        int diagonal;
    }
}
