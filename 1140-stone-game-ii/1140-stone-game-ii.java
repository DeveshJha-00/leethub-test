class Solution {
    private int[][][] dp = new int[2][101][101];

    public int stoneGameII(int[] piles) {
        for (int [][] rows : dp){
            for (int[] r : rows) Arrays.fill(r, -1);
        }
        return solveForAlice(1, 0, 1, piles);
    }

    public int solveForAlice(int isAlice, int idx, int M, int[] piles){
        int n = piles.length;
        if (idx >= n) return 0;

        if (dp[isAlice][idx][M] != -1) return dp[isAlice][idx][M];

        int res;
        if (isAlice == 1) res = Integer.MIN_VALUE;
        else res = Integer.MAX_VALUE;

        int stones = 0;
        for (int x = 1; x <= Math.min(2*M, n-idx); x++){
            stones += piles[idx + x - 1];

            if (isAlice == 1){
                res = Math.max(res, stones + solveForAlice(0, idx+x, Math.max(x,M), piles));
            }else{
                res = Math.min(res, solveForAlice(1, idx+x, Math.max(x,M), piles));
            }
        }

        return dp[isAlice][idx][M] = res;
    }
}