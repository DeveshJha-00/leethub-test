class Solution {
    public int maxProduct(int[] nums) {
        int maxi=-1, secondMaxi=-1;
        
        for (int num : nums){
            if (num > maxi){
                secondMaxi = maxi;
                maxi = num;
            }else if (num > secondMaxi){
                secondMaxi = num;
            }
        }

        return (maxi-1) * (secondMaxi-1);
    }
}