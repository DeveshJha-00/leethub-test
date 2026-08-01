class Solution {
    Integer[][][] dp;

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new Integer[2][n][n];

        int total = 0;
        for (int x : nums) total += x;

        int p1 = solveForP1(1, 0, n - 1, nums);
        int p2 = total - p1;

        return p1 >= p2;
    }

    public int solveForP1(int isP1, int l, int r, int[] nums) {
        if (l > r) return 0;

        if (dp[isP1][l][r] != null)return dp[isP1][l][r];

        int res;

        if (isP1 == 1){
            res = Math.max(
                nums[l] + solveForP1(0, l + 1, r, nums),
                nums[r] + solveForP1(0, l, r - 1, nums));
        } else{
            res = Math.min(
                solveForP1(1, l + 1, r, nums),
                solveForP1(1, l, r - 1, nums));
        }

        return dp[isP1][l][r] = res;
    }
}