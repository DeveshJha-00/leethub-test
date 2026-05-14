class Solution {
    public boolean isGood(int[] nums) {
        int maxEle = Integer.MIN_VALUE;
        for (int num : nums) maxEle=Math.max(maxEle, num);

        if (maxEle + 1 != nums.length) return false;

        int[] freq = new int[maxEle + 1];
        for (int i=0; i<nums.length; i++){
            freq[nums[i]]++;
            
            if (nums[i] != maxEle && freq[nums[i]] > 1) return false;
            if (nums[i] == maxEle && freq[nums[i]] > 2) return false;
        }

        return true;
    }
}