import java.util.*;

class Solution {

    public boolean isSafe(int row, int col, char[][] board) {

        // Horizontal
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Vertical
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper left
        int r = row;
        for (int c = col; c >= 0 && r >= 0; c--, r--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Upper right
        r = row;
        for (int c = col; c < board.length && r >= 0; c++, r--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Lower left
        r = row;
        for (int c = col; c >= 0 && r < board.length; c--, r++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Lower right
        r = row;
        for (int c = col; c < board.length && r < board.length; c++, r++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void saveBoard(char[][] board, List<List<String>> allBoards) {

        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {

            String row = "";

            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == 'Q') {
                    row += 'Q';
                } else {
                    row += '.';
                }
            }

            newBoard.add(row);
        }

        allBoards.add(newBoard);
    }

    public void helper(char[][] board,
                       List<List<String>> allBoards,
                       int col) {

        // All queens placed
        if (col == board.length) {
            saveBoard(board, allBoards);
            return;
        }

        // Try every row in current column
        for (int row = 0; row < board.length; row++) {

            if (isSafe(row, col, board)) {

                // Choose
                board[row][col] = 'Q';

                // Explore
                helper(board, allBoards, col + 1);

                // Undo
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> allBoards = new ArrayList<>();

        char[][] board = new char[n][n];

        // Initialize board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        helper(board, allBoards, 0);

        return allBoards;
    }
}