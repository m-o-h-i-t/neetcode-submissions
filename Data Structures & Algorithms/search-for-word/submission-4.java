class Solution {
    static int[] xd = {1, 0, -1, 0};
    static int[] yd = {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, "" + word.charAt(0), 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int row, int col, String word, String wsf, int index) {
        if (word.equals(wsf)) {  
            return true;
        }

        char temp = board[row][col];  // Store the current character
        board[row][col] = '#';  // Mark as visited

        for (int i = 0; i < 4; i++) {
            int x = row + xd[i];
            int y = col + yd[i];

            if (x >= 0 && y >= 0 
                && x < board.length 
                && y < board[0].length
                && board[x][y] != '#'  
                && index < word.length()
                && board[x][y] == word.charAt(index)) {
                if(dfs(board, x, y, word, wsf + board[x][y], index + 1)){
                    return true;
                }
        }

       
    }
     board[row][col] = temp;  
        return false;
    }
}
