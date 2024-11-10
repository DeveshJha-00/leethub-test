class Solution {
    public int maxProduct(int[] nums) {
        // int maxProd=nums[0], currProd=nums[0], n=nums.length;
        // for (int i=1; i<n; i++){
        //     currProd *= nums[i];
        //     maxProd = Math.max(maxProd, currProd);
        // }
        // return maxProd;


        int pref=1, suff=1, n=nums.length;
        int prod=Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            if (pref==0) pref=1;
            if (suff==0) suff=1;
            pref *= nums[i];
            suff *= nums[n-i-1];
            prod=Math.max(prod, Math.max(pref,suff));
        }
        return prod;
}
}