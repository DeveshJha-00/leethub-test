class Solution {
    public int countInversions(int arr[], int n){
        int inversions = 0;
        for (int i=0;i<n-1;i++){
            if (arr[i] > arr[i+1]) inversions++;
        }
        return inversions;
    }
    public boolean check(int[] nums) {
        int n = nums.length;
        int inversions = countInversions(nums,n);
        if (inversions==0){
            for (int i=0;i<n-1;i++){
                if (nums[i]>nums[i+1]) return false;
            }
            return true;
        }
        if (inversions==1 && nums[n-1]<=nums[0]) return true;
        return false;
    }
}