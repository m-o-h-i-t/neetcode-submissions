class Solution {
    static int xd[] = {1, 0, -1, 0};
    static int yd[] = {0, 1, 0, -1};

    private int cmax;

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    cmax = 0;
                    dfs(grid, i, j);
                    if(cmax > max){
                        max = cmax;
                    }
                }
            }
        }

        return max;
        
    }

    public void dfs(int[][] grid, int x, int y){
        grid[x][y] = -1;
        cmax++;

        for(int i = 0; i < 4; i++){
            int xdir = x + xd[i];
            int ydir = y + yd[i];

            if(xdir >= 0 && xdir < grid.length && ydir >=0 && ydir < grid[0].length && grid[xdir][ydir] == 1){
                dfs(grid, xdir, ydir);
            }
        }
    }
}
