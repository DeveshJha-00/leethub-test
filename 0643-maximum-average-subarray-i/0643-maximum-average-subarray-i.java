class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // double avg=0, curravg=0;
        // int left=0, right=k-1;
        // if (k==nums.length){
        //     for (int i=0;i<nums.length;i++){
        //         avg += nums[i];
        //     }
        //     return (avg/k);
        // }
        // while (right <= nums.length-1){
            // for (int i=left; i<=right; i++){
            //     curravg += nums[i];
            // }
            // curravg /= k;
            // avg = Math.max(curravg,avg);
            // curravg=0;
            // left++;
            // right++;
            // int currsum = 0;
        // }
        // return avg;
        double currSum=0;
        for (int i=0;i<k;i++){
            currSum += nums[i];
        }
        double maxSum = currSum;
        for (int i=k;i<nums.length;i++){
            currSum += nums[i];
            currSum -= nums[i-k];
            maxSum = Math.max(currSum, maxSum);
        } 
        return (maxSum/k);
    }
}