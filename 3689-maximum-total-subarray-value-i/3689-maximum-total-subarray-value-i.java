class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for (int ele : nums){
            max = Math.max(max, ele);
            min = Math.min(min, ele);
        }

        long ans = ((max - min) * k);
        return ans;
    }
}