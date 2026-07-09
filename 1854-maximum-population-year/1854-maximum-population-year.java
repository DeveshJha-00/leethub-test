class Solution {
    public int maximumPopulation(int[][] logs) {
        //BRUTE FORCE
        // int[] arr = new int[2051];

        // for (int[] log : logs){
        //     int start = log[0];
        //     int end = log[1];
        //     for (int j=start; j<end; j++){
        //         arr[j]++;
        //     }
        // }

        // int maxPop = Integer.MIN_VALUE;
        // int minYear = 1950;
        // for (int year=1951; year<=2050; year++){
        //     if (arr[year] > maxPop){
        //         maxPop = arr[year];
        //         minYear = year;
        //     }
        // }

        // return minYear;

        // DIFF ARR : 
        // int[] diff = new int[2051];
        // for (int[] log : logs){
        //     int start = log[0];
        //     int end = log[1];
        //     diff[start]++;
        //     diff[end]--;  // generally diff[end+1]--; but here end should not be inclusive hence diff[end-1+1]--
        // }

        // int cumSum = 0;
        // int maxPop = Integer.MIN_VALUE;
        // int minYear = Integer.MAX_VALUE;
        // for (int i=1950; i<=2050; i++){
        //     cumSum += diff[i];
        //     if (cumSum > maxPop){
        //         maxPop = cumSum;
        //         minYear = i;
        //     }
        // }

        // return minYear;

        
        // LINE SWEEP : 
         List<int[]> events = new ArrayList<>();

        for (int[] log : logs) {
            events.add(new int[]{log[0], +1}); // birth
            events.add(new int[]{log[1], -1}); // death
        }

        // If same year: death (-1) BEFORE birth (+1)
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // first col asc 
            return a[1] - b[1]; //second col -1 first
        });

        int curr = 0;
        int maxPop = 0;
        int minYear = 0;

        for (int[] e : events) {
            curr += e[1];
            if (curr > maxPop) {
                maxPop = curr;
                minYear = e[0];
            }
        }

        return minYear;
    }
}