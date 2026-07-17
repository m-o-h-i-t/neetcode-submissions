class Solution {
    static int[] xd = {1, 0, -1, 0};
    static int[] yd = {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        // Boundary checks
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all 4 directions
        for (int i = 0; i < 4; i++) {
            int x = row + xd[i];
            int y = col + yd[i];

            if (dfs(board, x, y, word, index + 1)) {
                return true;
            }
        }

        // Backtrack (restore the cell)
        board[row][col] = temp;

        return false;
    }
}
