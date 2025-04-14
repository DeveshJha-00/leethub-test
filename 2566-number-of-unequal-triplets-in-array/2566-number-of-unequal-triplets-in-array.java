class Solution {
    public int unequalTriplets(int[] nums) {
        int n=nums.length, ct=0;
        for (int i=0; i<=n-3; i++){
            for (int j=i+1; j<=n-2; j++){
                if (nums[i]!=nums[j]){
                    for (int k=j+1; k<=n-1; k++){
                        if ((nums[i]!=nums[k]) && (nums[j]!=nums[k])) ct++;
                    }
                }
            }
        }
        return ct;
    }
}