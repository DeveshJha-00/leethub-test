class Solution {
    private int[][] dirns = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxGold = 0;
        
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j] != 0){
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }

        return maxGold;
    }

    public int dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if (i<0 || i>=m || j<0 || j>=n || grid[i][j]==0) return 0;

        int currGold = grid[i][j];
        grid[i][j] = 0;
        
        int maxGold = 0;
        for (int[] dir : dirns){
            int newX = i+dir[0], newY=j+dir[1];
            maxGold = Math.max(maxGold, dfs(grid, newX, newY));
        }

        grid[i][j] = currGold;
        return currGold + maxGold; 
    }

}