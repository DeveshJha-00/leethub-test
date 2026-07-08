class Solution {

    static final int MOD = (int)(1e9 + 7);

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int q = queries.length;
        int[] res = new int[q];

        long[] digitSumUpto = new long[n];
        digitSumUpto[0] = s.charAt(0)-'0';
        for (int i=1; i<n; i++){
            digitSumUpto[i] = digitSumUpto[i-1] + s.charAt(i)-'0';
        }

        int[] numberUpto = new int[n];
        numberUpto[0] = s.charAt(0)-'0';
        for (int i=1; i<n; i++){
            if (s.charAt(i) == '0')
                numberUpto[i] = numberUpto[i-1];
            else
                // numberUpto[i] = (numberUpto[i-1] * 10 + s.charAt(i)-'0') % MOD; 
                numberUpto[i] = (int)(((long)numberUpto[i - 1] * 10 + (s.charAt(i) - '0')) % MOD);
        }

        int[] nonZeroCount = new int[n];
        nonZeroCount[0] = (s.charAt(0) != '0') ? 1 : 0;
        for (int i = 1; i < n; i++) {
            int digit = s.charAt(i) - '0';
            nonZeroCount[i] = nonZeroCount[i - 1] + (digit != 0 ? 1 : 0);
        }

        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;


        int idx = 0;
        for (int[] query : queries){
            int l = query[0], r = query[1];
            
            int  startCount = (l == 0) ? 0 : nonZeroCount[l - 1];
            int endCount  = nonZeroCount[r];
            int k = endCount - startCount;
            if (k == 0) {
                res[idx++] = 0;
                continue;
            }

            long numBefore  = (l == 0) ? 0 : numberUpto[l - 1];

            long x = (numberUpto[r] - (numBefore * pow10[k] % MOD) + MOD) % MOD;
            long sum = digitSumUpto[r] - ((l == 0) ? 0 : digitSumUpto[l - 1]);

            res[idx++] = (int) ((x * sum) % MOD);
        }

        return res;
    }
}