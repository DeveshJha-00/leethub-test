class Solution {
    private int[][] dirns = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public boolean isBoundary(int[][] grid, int x, int y){
        int n = grid.length, m = grid[0].length;
        if (x==0 || x==n-1 || y==0 || y==m-1) return true;
        return false;
    }

    public boolean isValid(int[][] grid, int x, int y){
        int n = grid.length, m = grid[0].length;
        if (x<0 || x>=n || y<0 || y>=m) return false;
        return true;
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int num = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (!vis[i][j] && grid[i][j]==1 && !isBoundary(grid, i, j)){
                    num += bfs(grid, i, j, vis);
                }
            }
        }

        return num;
    }

    public int bfs(int[][] grid, int i, int j, boolean[][] vis){
        // if (isBoundary(grid, i, j)) return 0; --> early return wont work
        boolean touchesBoundary = false;
        int num = 0;

        Queue<int[]> q = new LinkedList<>();
        vis[i][j] = true;
        q.offer(new int[]{i ,j});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            num++;
            int x = curr[0];
            int y = curr[1];
            if (isBoundary(grid, x, y)) touchesBoundary = true;
            for (int[] dir : dirns){
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if (isValid(grid, newX, newY) && !vis[newX][newY] 
                    && grid[newX][newY]==1){
                        vis[newX][newY] = true;
                        q.offer(new int[]{newX, newY});
                    }
            }
        }

        return (touchesBoundary) ? 0 : num;
    }
}