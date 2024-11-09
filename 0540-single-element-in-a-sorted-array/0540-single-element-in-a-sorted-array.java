class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // OWN TRY -> BINARY SEARCH
        // int low=0, high=n-1;
        // while (low<high){
        //     int mid = (low+high)/2;
        //     if (nums[mid] >= nums[low]) {
        //         if (nums[low] == nums[low+1]) low+=2;
        //         else return nums[low];
        //     }
        //     else if (nums[mid] < nums[high]) high-=2;
        // }
        // return nums[low];


        // ACTUAL BINARY SEARCH 
        int low=1, high=n-2;
        if (n==1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n-1] != nums[n-2]) return nums[n-1];

        while(low <= high){
            int mid = low + (high-low)/2;
            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            //if odd index and same ele on left AND the single ele is on right half
            if (mid%2==1 && nums[mid]==nums[mid-1] ||
                mid%2==0 && nums[mid]==nums[mid+1]) low=mid+1;
            else high=mid-1; 
        }
        return -1;
    }
}