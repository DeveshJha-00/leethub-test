class Solution {
    public int sumOfPrimesInRange(int n) {
        int cnt = 0;
        int rev = reverse(n);
        int low = Math.min(n, rev);
        int high = Math.max(n, rev);

        for (int i=low; i<=high; i++){
            if (isPrime(i)) cnt+=i;
        }
        return cnt;
    }

    private int reverse(int n){
        int rev = 0;
        while (n > 0){
            int rem = n % 10;
            rev = (rev * 10) + rem;
            n /= 10;
        }
        return rev;
    }

    private boolean isPrime(int n){
        if (n == 1) return false; 
        
        for (int i=2; i<=Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }

        return true;
    }
}