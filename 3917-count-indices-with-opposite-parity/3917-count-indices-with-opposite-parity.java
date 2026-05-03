class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int odd=0, even=0;
        
        for (int i=n-1; i>=0; i--){
            if (nums[i] % 2 == 0){
                even++;
                res[i] = odd;
            }else{
                odd++;
                res[i] = even;
            }
        }

        return res;
    }
}