class Solution {
    private Integer[][] dp;

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new Integer[n+1][n+1];

        return solve(nums, 0, n-1) >= 0;
    }

    public int solve(int[] nums, int l, int r){
        int n = nums.length;

        if (l > r) return 0;

        if (dp[l][r] != null) return dp[l][r];

        int takeLeft = nums[l] - solve(nums, l+1, r);
        int takeRight = nums[r] - solve(nums, l, r-1);

        return dp[l][r] = (int)(Math.max(takeLeft, takeRight));
    }
}