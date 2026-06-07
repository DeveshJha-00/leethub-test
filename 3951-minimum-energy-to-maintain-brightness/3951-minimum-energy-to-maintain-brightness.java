class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        long totalTime = 0;
        long start = intervals[0][0];
        long end = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {

            long currStart = intervals[i][0];
            long currEnd = intervals[i][1];

            if (currStart <= end) {
                end = Math.max(end, currEnd);
            } else {
                totalTime += end - start + 1;

                start = currStart;
                end = currEnd;
            }
        }
        totalTime += end - start + 1; //adding last interval
        // long bulbs = (brightness + 2L) / 3L;
        long bulbs = (long) Math.ceil((double) brightness / 3);

        return bulbs * totalTime;
    }
}