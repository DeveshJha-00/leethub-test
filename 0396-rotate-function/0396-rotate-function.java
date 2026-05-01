class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length, sum=0;
        int f0 = 0;

        for (int i=0; i<n; i++){
            sum += nums[i];
            f0 += i * nums[i];
        }

        int res = f0;
        
        for (int k=0; k<n; k++){
            int f = f0 + sum - (n*nums[n-1-k]);
            res = Math.max(res, f);
            f0 = f;
        }

        return res;
    }
}