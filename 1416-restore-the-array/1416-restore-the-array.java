class Solution {
    private int MOD = (int)1e9 + 7;

    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return solve(s, k, 0, dp);
    }

    private int solve(String s, int k, int start, int[] dp){
        if (start >= s.length()) return 1;

        if (dp[start] != -1) return dp[start];

        if (s.charAt(start) == '0') return dp[start] = 0;

        long ans = 0;
        long num = 0;

        for (int end=start; end<s.length(); end++){
            num = (num*10) + (s.charAt(end) - '0');
            if (num > k) break;

            ans = (ans%MOD + solve(s, k, end + 1, dp)%MOD) % MOD;
        }

        return dp[start] = (int)ans;
    }
}