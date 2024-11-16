class Solution {

    public int countSubarrays(int[] arr, int mid){
        int sum=0, subArrCount=1;
        for (int ele : arr){
            if ((sum+ele) <= mid){
                sum += ele;
            }else{
                sum = ele;
                subArrCount++;
            }
        }
        return subArrCount;
    }

    public int splitArray(int[] nums, int k){
        int minPossibleMax = Integer.MIN_VALUE;
        int maxPossibleMax = 0;
        for (int ele : nums){
            minPossibleMax = Math.max(minPossibleMax, ele);
            maxPossibleMax += ele;
        }
        int low=minPossibleMax, high=maxPossibleMax;
        while (low<=high){
            int mid = low + (high-low)/2;
            int noOfSubarrays = countSubarrays(nums,mid);
            if (noOfSubarrays > k) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}