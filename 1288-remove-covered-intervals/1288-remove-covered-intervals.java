class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        res.add(intervals[0]);

        for (int i=1; i<n; i++){
            int[] lastInterval = res.get(res.size()-1);
            if (lastInterval[0] <= intervals[i][0] && lastInterval[1] >= intervals[i][1]){
                continue;
            }else{
                res.add(intervals[i]);
            }
        }
        
        return res.size();
    }
}