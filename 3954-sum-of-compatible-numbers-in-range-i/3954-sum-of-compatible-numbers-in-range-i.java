class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int left = Math.max(1, n-k);
        int right = n+k;

        int res = 0;
        for (int i=left; i<=right; i++){
            if ((n&i)==0 && Math.abs(n-i)<=k) res+=i;
        }

        return res;
    }
}