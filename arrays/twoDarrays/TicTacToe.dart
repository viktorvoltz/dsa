/**
 * @author viktorvoltz
 */

class TicTacToe {
  static int row = 3, col = 3;
  static final int X = 1, O = -1, EMPTY = 0;

  late int player;

  List<List<int>> board = List.generate(
      row, (index) => List.filled(col, 0, growable: false),
      growable: false);

  TicTacToe() {
    clearBoard();
  }

  void clearBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = EMPTY;
      }
    }
    player = X;
  }

  void putMark(int i, int j) {
    if ((i < 0) || (i > 2) || (j < 0) || (j > 2))
      throw RangeError("Invalid board position");
    if (board[i][j] != EMPTY) throw RangeError("Board position occupied");
    board[i][j] = player;
    player = -player;
  }

  bool isWin(int mark) {
    return ((board[0][0] + board[0][1] + board[0][2] == mark * 3) // row 0
        ||
        (board[1][0] + board[1][1] + board[1][2] == mark * 3) // row 1
        ||
        (board[2][0] + board[2][1] + board[2][2] == mark * 3) // row 2
        ||
        (board[0][0] + board[1][0] + board[2][0] == mark * 3) // column 0
        ||
        (board[0][1] + board[1][1] + board[2][1] == mark * 3) // column 1
        ||
        (board[0][2] + board[1][2] + board[2][2] == mark * 3) // column 2
        ||
        (board[0][0] + board[1][1] + board[2][2] == mark * 3) // diagonal
        ||
        (board[2][0] + board[1][1] + board[0][2] == mark * 3)); // rev diag
  }

  int winner() {
    if (isWin(X))
      return (X);
    else if (isWin(O))
      return (O);
    else
      return (0);
  }
}
