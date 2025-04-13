class Solution {
    final int M = (int)1e9+7;
    public int countGoodNumbers(long n) {
        long evenPos = (n+1)/2;
        long oddPos = n/2;
        long ans = (powerFn(5,evenPos) * powerFn(4,oddPos)) % M;
        return (int)ans;
    }
    public long powerFn(int a, long b){
        if (b==0) return 1;
        long half = powerFn(a,b/2);
        long res = (half*half) % M;
        if (b%2==1) res=(res*a) % M;
        return res;
    }
}