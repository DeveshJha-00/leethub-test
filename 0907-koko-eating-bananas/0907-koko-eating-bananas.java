class Solution {
    public int totalTime(int[] arr, int h){
        int timeTaken=0;
        for (int ele : arr){
            timeTaken += Math.ceil((double)ele / (double)h);
        }
        return timeTaken;
    }
    public int maxEle(int[] arr){
        int maxEl=arr[0];
        for (int ele:arr){
            maxEl = Math.max(maxEl, ele);
        }
        return maxEl;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = maxEle(piles);
        int low=1, high=max;
        while (low <= high){
            int mid = low + (high-low)/2;
            int time = totalTime(piles, mid);
            if (time <= h) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}