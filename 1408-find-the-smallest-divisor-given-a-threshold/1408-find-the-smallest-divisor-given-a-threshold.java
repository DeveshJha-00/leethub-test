class Solution {
    public int sumByDivisor(int[]arr, int n){
        int sum=0;
        for (int ele : arr){;
            sum += Math.ceil((double)ele / (double)n);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        if (n > threshold) return -1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        int low=1, high=max;
        while (low <= high){
            int mid = (low + high)/2;
            int sum = sumByDivisor(nums, mid);
            if (sum <= threshold) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}