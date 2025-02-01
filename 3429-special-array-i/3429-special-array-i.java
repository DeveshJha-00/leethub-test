class Solution {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) return true;
        for (int i = 0; i < nums.length-1; i++) {
            // int first = nums[i];
            // int second = nums[i+1];
            // if ((first % 2 == 0) && (second % 2 == 0)) return false;
            // else if ((first % 2 != 0) && (second % 2 != 0)) return false;
            if (nums[i]%2 == nums[i+1]%2) return false;
        }

        return true;
    }
}