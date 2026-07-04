class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long total = 0;
        int ptr = nums.length-1;

        while (k > 0){
            long curr = nums[ptr--];

            if (mul >= 2){
                total += (curr * mul);
            }else{
                total += curr;
            }
            mul--;
            k--;
        }

        return total;
    }
}