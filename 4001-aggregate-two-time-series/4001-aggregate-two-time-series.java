class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> res = new ArrayList<>();
        int n1 = series1.length, n2 = series2.length;

        int p1=0, p2=0;
        while (p1 < n1 && p2 < n2){
            int start1 = series1[p1][0], start2 = series2[p2][0];
            
            if (start1 <= start2){
                res.add(Arrays.asList(start1, series1[p1][1] + series2[p2][1]));
                p1++;
                if (start1 == start2) p2++;
            }else{
                res.add(Arrays.asList(start2, series1[p1][1] + series2[p2][1]));
                p2++;
            }
        }

        while (p1 < n1){
            res.add(Arrays.asList(series1[p1][0], series1[p1][1]));
            p1++;
        }

        while(p2 < n2){
            res.add(Arrays.asList(series2[p2][0], series2[p2][1]));
            p2++;
        }

        return res;
    }
}