class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int[] diff = new int[n];
        for (int[] query : queries){
            int start = query[0];
            int end = query[1];
            diff[start] += 1;
            if (end+1 < n) diff[end+1] -= 1;
        }
        int[] check = new int[n];
        int cumSum=0;
        for (int i=0; i<n; i++){
            cumSum += diff[i];
            check[i] = cumSum;
        }
        for (int i=0; i<n; i++){
            if (check[i] < nums[i]) return false;
        }
        return true;
    }
}