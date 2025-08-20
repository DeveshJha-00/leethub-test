class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        for (int i=1; i<n; i++){
            if (nums[i] > res.get(res.size()-1)){
                res.add(nums[i]);
            }else{
                // Index at which the current element must be placed
                //lower bound
                int ind = Collections.binarySearch(res, nums[i]);
                if (ind < 0) ind = -(ind + 1);
                res.set(ind, nums[i]);
            }
        }
        return res.size();
        
        // int[][] dp = new int[n][n+1];
        // for(int[] r : dp) Arrays.fill(r, -1);
        // return solve(nums, 0, -1, dp);
    }

    public int solve(int[] nums, int idx, int prevIdx, int[][] dp){
        if (idx==nums.length) return 0;

        if (dp[idx][prevIdx+1] != -1) return dp[idx][prevIdx+1];

        int notPick = solve(nums, idx+1, prevIdx, dp);
        int pick = Integer.MIN_VALUE;
        if (prevIdx==-1 || nums[idx]>nums[prevIdx]){
            pick = 1 + solve(nums, idx+1, idx, dp);
        }
        return dp[idx][prevIdx+1] = Math.max(pick, notPick);
    }
}

