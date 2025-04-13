class Solution {
    
    public double myPow(double x, int n) {
        if (n<0){ //EDGE CASE/S
            x=1/x;
            long N = -(long)n; //IF n=INT_MIN
            return myPow(x, N);
        }
        return myPow(x,(long)n);
    }

    //MAIN BINARY EXPONENTIATION FN.
    public double myPow(double x, long n){
        if (n==0) return 1;
        double half = myPow(x,n/2);
        double res = half*half;
        if (n%2==1) res=res*x;
        return res;
    }
}