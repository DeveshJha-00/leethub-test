class Solution {
    public boolean isPerfectSquare(int num) {
        if (num==1) return true;
        int low=1, high=(num/2)+1;
        while (low <= high){
            int mid = low+(high-low)/2;
            long sqaureOfMid = (long) mid*mid;
            if (sqaureOfMid == num) return true;
            else if (sqaureOfMid > num) high=mid-1;
            else low = mid+1;
        }
        return false;
    }
}