class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length, n=grid[0].length;
        int size = m * n;
        k %= size;

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++) list.add(grid[i][j]);
        }

        List<Integer> temp = new ArrayList<>();
        for (int i=list.size()-k; i<list.size(); i++) temp.add(list.get(i));

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            ans.add(0);
        } // so no errors while using ans.get(i)

        for (int i=0; i<k; i++) {
            ans.set(i, temp.get(i));
        }


        for (int i=k; i<list.size(); i++) {
            ans.set(i, list.get(i - k));
        }

        List<List<Integer>> res = new ArrayList<>();
        int idx = 0;

        for (int i=0; i<m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(ans.get(idx++));
            }

            res.add(row);
        }

        return res;

    }   
}