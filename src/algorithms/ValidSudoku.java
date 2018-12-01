package algorithms;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (!validRows(board)) {
            return false;
        }

        if (!validColumns(board)) {
            return false;
        }

        if (!validSubBoard(board)) {
            return false;
        }

        return true;
    }

    private static boolean validRows(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] set = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (set[c - '1']) {
                    return false;
                } else {
                    set[c - '1'] = true;
                }
            }
        }
        return true;
    }

    private static boolean validColumns(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] set = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c == '.') continue;
                if (set[c - '1']) {
                    return false;
                } else {
                    set[c - '1'] = true;
                }
            }
        }
        return true;
    }

    private static boolean validSubBoard(char[][] board) {
        for (int k = 0; k < 9; k += 3) {
            for (int l = 0; l < 9; l += 3) {
                boolean[] set = new boolean[9];
                for (int i = k; i < k + 3; i++) {
                    for (int j = l; j < l + 3; j++) {
                        char c = board[i][j];
                        if (c == '.') continue;
                        if (set[c - '1']) {
                            return false;
                        } else {
                            set[c - '1'] = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '1', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        ValidSudoku sudoku = new ValidSudoku();
        System.out.println(sudoku.isValidSudoku(board));
    }
}
