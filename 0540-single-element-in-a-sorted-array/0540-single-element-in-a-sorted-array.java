class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0, high=nums.length-1;
        while (low<high){
            int mid = (low+high)/2;
            if (nums[mid] >= nums[low]) {
                if (nums[low] == nums[low+1]) low+=2;
                else return nums[low];
            }
            else if (nums[mid] < nums[high]) high-=2;
        }
        return nums[low];
    }
}