class Solution {
    public int findGCD(int[] nums) {
        int minEl=Integer.MAX_VALUE, maxEl=Integer.MIN_VALUE;
        for (int num : nums){
            minEl = Math.min(minEl, num);
            maxEl = Math.max(maxEl, num);
        }

        int gcd = 1;
        for (int i=2; i<=minEl; i++){
            if ((minEl % i == 0 ) && (maxEl % i == 0)) gcd=i;
        }

        return gcd;
    }
}