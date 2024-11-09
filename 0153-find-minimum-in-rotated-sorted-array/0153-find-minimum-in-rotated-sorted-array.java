class Solution {
    public int findMin(int[] nums) {

        // O(N) complexity --> linear search
        // for (int i=0; i<nums.length-1; i++){
        //     if (nums[i] > nums[i+1]) return nums[i+1];
        // }
        // return nums[0];

        //O(log N) --> binary search 
        int low=0, high=nums.length-1;
        while (low<high){
            int mid = (low+high) / 2;
            if (nums[mid] > nums[high]) low = mid+1;
            else high = mid;
        }
        return nums[low];

    }
}