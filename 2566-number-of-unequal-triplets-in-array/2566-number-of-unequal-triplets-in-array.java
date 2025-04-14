class Solution {
    public int unequalTriplets(int[] nums) {
        // int n=nums.length, ct=0;
        // for (int i=0; i<=n-3; i++){
        //     for (int j=i+1; j<=n-2; j++){
        //         if (nums[i]!=nums[j]){
        //             for (int k=j+1; k<=n-1; k++){
        //                 if ((nums[i]!=nums[k]) && (nums[j]!=nums[k])) ct++;
        //             }
        //         }
        //     }
        // }
        // return ct;

        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int count=0;
        int left=0;
        int right = nums.length;
        for(Map.Entry<Integer,Integer> i : hm.entrySet()){
            int freq = i.getValue();
            right-=freq;
            count+=left*freq*right;
            left+=freq;
        }
        return count;
    }
}