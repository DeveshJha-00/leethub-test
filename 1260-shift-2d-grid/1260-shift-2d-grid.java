class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length, n=grid[0].length;
        int size = m * n;
        k %= size;

        reverse(grid, 0, size-1);
        reverse(grid, 0, k-1);
        reverse(grid, k, size-1);

        List<List<Integer>> res = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> list = new ArrayList<>();
            for (int val : row) {
                list.add(val);
            }
            res.add(list);
        }

        return res;
    }   

    public void reverse(int[][] grid, int i, int j){
        int rows=grid.length, cols=grid[0].length;

        while (i < j){
            int temp = grid[i/cols][i%cols];
            grid[i/cols][i%cols] = grid[j/cols][j%cols];
            grid[j/cols][j%cols] = temp;

            i++; j--;
        }
    }
}