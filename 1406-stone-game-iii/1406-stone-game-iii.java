class Solution {
    private Integer[] dp;

    public String stoneGameIII(int[] stones) {
        dp = new Integer[stones.length + 1];
        int diff = solve(stones, 0);

        if (diff > 0) return "Alice";
        if (diff < 0) return "Bob";
        return "Tie";
    }

    public int solve(int[] stones, int idx){
        int n = stones.length;
        if (idx >= n) return 0;

        if (dp[idx] != null) return dp[idx];

        int res = Integer.MIN_VALUE;
        
        res = Math.max(res, stones[idx] - solve(stones, idx+1));
        if (idx+1 < n)
            res = Math.max(res, stones[idx] + stones[idx+1] - solve(stones, idx+2));
        if (idx+2 < n)
            res = Math.max(res, stones[idx] + stones[idx+1] + stones[idx+2] - solve(stones, idx+3));
        
        return dp[idx] = res;
    }
}