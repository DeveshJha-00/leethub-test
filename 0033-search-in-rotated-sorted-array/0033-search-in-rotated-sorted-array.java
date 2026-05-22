class Solution {
    public int search(int[] nums, int k) {
        int low=0, high=nums.length-1;

        while (low <= high){
            int mid = (low + high)/2;
            if (nums[mid] == k) return mid;

            if (nums[low] <= nums[mid]){ //left half sorted
                if (nums[low]<=k && k<=nums[mid]){ //target(k) in that sorted left half
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{ //right half sorted
                if (nums[mid]<=k && k<=nums[high]){ //target(k) in that sorted right half
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        
        return -1;
    }
}