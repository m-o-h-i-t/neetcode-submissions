

class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValidRowWise(board) && isValidColumnWise(board) && isValidGridWise(board);
    }

    public boolean isValidRowWise(char[][] board){
        for(int i = 0; i < 9; i++){
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < 9; j++){
                char ch = board[i][j];
                if(ch != '.' && !set.add(ch)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidColumnWise(char[][] board){
        for(int i = 0; i < 9; i++){
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < 9; j++){
                char ch = board[j][i];
                if(ch != '.' && !set.add(ch)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidGridWise(char[][] board){
        for(int i = 0; i < 9; i += 3){
            for(int j = 0; j < 9; j += 3){
                Set<Character> set = new HashSet<>();
                for(int k = 0; k < 9; k++){
                    int row = i + k / 3;
                    int col = j + k % 3;
                    char ch = board[row][col];
                    if(ch != '.' && !set.add(ch)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
