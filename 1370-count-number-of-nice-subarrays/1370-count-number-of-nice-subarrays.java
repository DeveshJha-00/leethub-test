class Solution {
    public int arraysWithLessThanEqualToKOddNos(int[] nums, int k){
        int l=0, r=0, ct=0, sum=0, n=nums.length;
        while (r<n){
            sum += nums[r] % 2;
            while (sum > k){
                sum -= nums[l]%2;
                l++;
            }
            ct += r-l+1;
            r++;
        }
        return ct;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return arraysWithLessThanEqualToKOddNos(nums,k)-arraysWithLessThanEqualToKOddNos(nums,k-1);
    }
}