/*
 * @author donhk
 * 08/02/20
 */
public enum Evaluation {
    InvalidInput, // The string provided does not describe a valid tic-tac-toe board
    NoWinner, // valid board, but the game hasn't been won by either player yet
    Xwins, // valid board, and the game was won by player X
    Owins, // valid board, and the game was won by player Y
    UnreachableState // string describes a board, but not a board state that is reachable from a valid game
}
