class Solution {
    public boolean checkGoodInteger(int n) {
        long digitSum=0;
        long squareSum=0;
        while(n > 0){
            int dig = n % 10;
            n /= 10;
            digitSum += dig;
            squareSum += dig*dig;
        }

        return ((squareSum - digitSum) >= 50);
    }
}