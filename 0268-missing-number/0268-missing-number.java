class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int target = n*(n+1)/2;
        int sum=0;
        for (int ele:nums) sum+=ele;
        return (target-sum);
    }
}