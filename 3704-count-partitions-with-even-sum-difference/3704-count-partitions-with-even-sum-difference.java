class Solution {
    public int countPartitions(int[] nums) {
        int ct=0;
        int total=0, leftsum=0, rightsum=0;
        for (int ele:nums) total+=ele;
        for (int i=0; i<nums.length-1; i++){
            leftsum += nums[i];
            rightsum = total-leftsum;
            if ( (leftsum-rightsum)%2 == 0) ct++;
        }
        return ct;
    }
}