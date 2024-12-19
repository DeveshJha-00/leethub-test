class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen=0, n=nums.length;

        // for (int i=0; i<n; i++){
        //     int zeros=0;
        //     for (int j=i; j<n; j++){
        //         if (nums[j] == 0) zeros++;
        //         if (zeros <= k){
        //             maxLen = Math.max(maxLen, j-i+1);
        //         }
        //         else break;
        //     }
        // }
        // return maxLen;

        int l=0, r=0, zeros=0;
        while (r<n){
            if (nums[r] == 0) zeros++;

            if (zeros>k){
            while (nums[l]!=0) l++;
            zeros--;
            l++;
            }

            if (zeros <= k){
                maxLen = Math.max(maxLen, r-l+1);
                r++;
            }
        }

        return maxLen;
    }
}












