class Solution {
    Integer[][][] dp;
    int n;

    public boolean stoneGame(int[] piles) {
        this.n = piles.length;
        this.dp = new Integer[2][n+1][n+1];;
        return solveForAlice(piles, 0, n-1, 1) > 0; //return alice - bob
    }

    public int solveForAlice(int[] piles, int l, int r, int isAlice){
        if (l > r) return 0;

        if (dp[isAlice][l][r] != null) return dp[isAlice][l][r];

        int res;
        if (isAlice == 1) res=Integer.MIN_VALUE;
        else res=Integer.MAX_VALUE;

        int count = 0;
        if (isAlice == 1){
            int left = piles[l] - solveForAlice(piles, l+1, r, 0);
            int right = piles[r] - solveForAlice(piles, l, r-1, 0);
            res = Math.max(res, Math.max(left, right));
        }else{
            int left = solveForAlice(piles, l+1, r, 0);
            int right = solveForAlice(piles, l, r-1, 0);
            res = Math.min(res, Math.min(left, right));
        }

        return  dp[isAlice][l][r] = res;
    }
}