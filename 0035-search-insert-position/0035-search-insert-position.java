class Solution {
    public int searchInsert(int[] arr, int target) {
        // int ans=0;
        // for (int i=0;i<nums.length;i++){
        //     if (nums[i]==target || nums[i]>target){
        //         ans = i;
        //         break;
        //     }
        //     // else if (nums[i]>target){
        //     //     ans = i;
        //     //     break;
        //     // }
        //     else{
        //         ans = nums.length;
        //     }
        // }
        // return ans;
        int n = arr.length;
        int left=0,right=n-1,mid;
        while(left<=right){
            mid = (left+right)/2;
            if (arr[mid] > target) right=mid-1;
            else if (arr[mid] < target) left=mid+1;
            else return mid;
        }
        return left;
    }
}