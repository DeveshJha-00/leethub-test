class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currCount=0, maxCount=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==1) currCount++;
            else currCount=0;
            maxCount = Math.max(currCount,maxCount);
        }
    return maxCount;
    }
}