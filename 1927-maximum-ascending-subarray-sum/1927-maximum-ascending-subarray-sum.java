class Solution {
    public int maxAscendingSum(int[] nums) {

        if (nums.length==1) return nums[0];
        int maxSum=nums[0];
        int sum=nums[0];

        for (int i=1; i<nums.length; i++){
            if (nums[i-1]<nums[i]){
                sum+=nums[i];
            }else{
                maxSum=Math.max(sum,maxSum);
                sum=nums[i];
            }
        }
        maxSum=Math.max(sum,maxSum);
        return maxSum;

        // int i=1;
        // while (i<nums.length){
        //     if (nums[i-1] < nums[i]) sum+=nums[i];
        //     else{
        //         maxSum = Math.max(sum,maxSum);
        //         sum=nums[i];
        //     }
        //     i++;
        // }
        // maxSum = Math.max(sum,maxSum);
        // return maxSum;
    }
}