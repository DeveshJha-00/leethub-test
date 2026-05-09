class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[46];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return solve(n, dp);
    }

    private int solve(int n, int[] dp){
        if (n <= 1){
            return 1;
        }

        if (dp[n] != -1){
            return dp[n];
        }

        int one = solve(n-1, dp);
        int two = solve(n-2, dp);
        return dp[n] = one + two;
    }
}