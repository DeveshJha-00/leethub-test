class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length, n=grid[0].length;
        int size = m * n;
        k %= size;

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++) list.add(grid[i][j]);
        }

        reverse(list, 0, list.size()-1);
        reverse(list, 0, k-1);
        reverse(list, k, list.size()-1);

        List<List<Integer>> res = new ArrayList<>();
        int idx = 0;
        for (int i=0; i<m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(list.get(idx++));
            }

            res.add(row);
        }

        return res;

    }   

    public void reverse(List<Integer> list, int i, int j){
        while (i < j){
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++; j--;
        }
    }
}