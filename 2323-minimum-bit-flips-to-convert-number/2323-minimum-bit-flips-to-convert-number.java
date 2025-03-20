class Solution {

    public int noOfSetBits(int n){
        int ct=0;
        while (n>0){
            n=n&n-1;
            ct++;
        }
        return ct;
    }

    public int minBitFlips(int start, int goal) {
        int temp = start^goal;
        return noOfSetBits(temp);
    }

}