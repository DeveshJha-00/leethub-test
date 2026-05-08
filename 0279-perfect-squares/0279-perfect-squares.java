class Solution {
    public int numSquares(int n) {
        int[] dp = new int[10001];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    private int solve(int n, int[] dp){
        if (n==0) return 0;

        if (dp[n] != -1) return dp[n];

        int minCount = Integer.MAX_VALUE;
        for (int i=1; i<=Math.sqrt(n); i++){
            int res = 1 + solve(n - i*i, dp);
            minCount = Math.min(minCount, res);
        }

        return dp[n] = minCount;
    }
}