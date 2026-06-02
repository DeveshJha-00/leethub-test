class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landFirst = solve(landStartTime,landDuration,waterStartTime,waterDuration);
        int waterFirst = solve(waterStartTime, waterDuration,landStartTime,landDuration);
        return Math.min(landFirst, waterFirst);
    }

    private int solve(int[] firstStart, int[] firstDuration,
                    int[] secondStart, int[] secondDuration){
        
        int earliestFinish = Integer.MAX_VALUE;
        for (int i=0; i<firstStart.length; i++){
            earliestFinish = Math.min(earliestFinish, 
                            firstStart[i] + firstDuration[i]);
        }

        int minTime = Integer.MAX_VALUE;

        for (int i=0; i<secondStart.length; i++){
            int startTime = Math.max(earliestFinish, secondStart[i]);
            int finishTime = startTime + secondDuration[i];

            minTime = Math.min(minTime, finishTime);
        }

        return minTime;
    }
}