class Solution {

    public boolean possible(int[] arr, int mid, int m, int k){
        int noOfBoquets=0, ct=0;
        for (int ele : arr){
            if (ele <= mid) ct++;
            else{
                noOfBoquets += (ct/k);
                ct=0;
            }
        }
        noOfBoquets += (ct/k);
        return noOfBoquets>=m ;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long)m*k > n) return -1;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int ele : bloomDay){
            low = Math.min(low, ele);
            high = Math.max(high, ele);
        }
        
        while (low <= high){
            int mid = low + (high-low)/2;
            if (possible(bloomDay, mid, m, k)) high=mid-1;
            else low=mid+1; 
        } 
        return low;
    }
}