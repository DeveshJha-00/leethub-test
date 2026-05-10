class Solution {
    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int ans = solve(nums, target, 0, dp);
        if (ans < 0) return -1;
        return ans;
    }

    private int solve(int[] nums, int target, int i, int[] dp){
        int n = nums.length;
        if (i == n-1){
            return dp[i] = 0;
        }

        if (dp[i] != Integer.MIN_VALUE){
            return dp[i];
        }

        int res = Integer.MIN_VALUE;
        for (int j=i+1; j<n; j++){
            if (Math.abs(nums[j] - nums[i]) <= target){
                int temp = 1 + solve(nums, target, j, dp);
                res = Math.max(res, temp);
            }
        }

        return dp[i] = res;
    }
}