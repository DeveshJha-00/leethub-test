class Solution {
    public int countOdds(int low, int high) {
        int oddNosTillHigh = (high+1)>>1;
        int oddNosTillLow = low>>1;
        return (oddNosTillHigh - oddNosTillLow);
    }
}