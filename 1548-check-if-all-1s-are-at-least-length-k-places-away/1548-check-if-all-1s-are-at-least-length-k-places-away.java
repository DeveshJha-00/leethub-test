class Solution {
    public boolean kLengthApart(int[] nums, int k) {
    int flag = -1; 
    for (int i=0; i<nums.length; i++){
        if (nums[i] == 1) {
            if (flag!=-1 && (i-flag-1) < k) {
                return false;  
            }
            flag = i;
        }
    }
    return true;
}

}