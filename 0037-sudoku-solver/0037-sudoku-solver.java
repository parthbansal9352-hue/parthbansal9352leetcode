class Solution {
    public boolean isSafe(char[][] board, int row, int col, int number) {
        char val = (char) (number + '0');
        
        for (int i = 0; i < 9; i++) {
            // Row check
            if (board[row][i] == val) return false;
            // Column check
            if (board[i][col] == val) return false;
            // 3x3 Grid check
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val) return false;
        }
        return true;
    }

    public boolean helper(char[][] board, int row, int col) {
        // Base Condition: Board fill ho gaya
        if (row == 9) {
            return true;
        }

        // Next cell coordinates
        int nrow = (col == 8) ? row + 1 : row;
        int ncol = (col == 8) ? 0 : col + 1;

        // Agar cell pehle se filled hai
        if (board[row][col] != '.') {
            return helper(board, nrow, ncol);
        }

        // Empty cell: 1 se 9 tak try karo
        for (int i = 1; i <= 9; i++) {
            if (isSafe(board, row, col, i)) {
                board[row][col] = (char) (i + '0');
                
                if (helper(board, nrow, ncol)) {
                    return true;
                }
                
                // Backtrack
                board[row][col] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
}