class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i=0; i<n; i++){
            int cnt = 0;
            for (int j=i+1; j<n; j++){
                if ((nums[i] & 1) != (nums[j] & 1)) cnt++;
            }
            res[i] = cnt;
        }
        return res;
    }
}