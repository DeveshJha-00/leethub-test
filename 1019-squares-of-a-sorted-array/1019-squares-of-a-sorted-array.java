class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int i;

        for (i=0; i<n; i++){
            if (nums[i] >= 0){
                break;
            }
        }

        int left=i-1, right=i, idx=0;
        int[] res = new int[n];

        while(left>=0 && right<n){
            if (nums[left]*nums[left] < nums[right]*nums[right]){
                res[idx++] = nums[left]*nums[left];
                left--;
            }else{
                res[idx++] = nums[right]*nums[right];
                right++;
            }
        }
        
        while(right<n){
            res[idx++] = nums[right]*nums[right];
            right++;
        }
        while (left>=0){
            res[idx++] = nums[left]*nums[left];
            left--;
        }
        return res;
    }
}