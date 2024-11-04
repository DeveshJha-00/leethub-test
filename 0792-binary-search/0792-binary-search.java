class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int ans=-1;
        int left=0,right=n-1,mid;
        while (left<=right){
            mid = (left+right)/2;
            if (nums[mid]>target){
                right=mid-1;
            }
            else if (nums[mid]<target){
                left=mid+1;
            }
            else{
                ans=mid;
                return ans;
            }
        }
        return ans;
    }
}