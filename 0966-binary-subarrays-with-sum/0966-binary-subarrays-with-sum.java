class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        //COUNT SUBBARAYS WITH SUM=K APPROACH (CAN BE OPTIMIZED FUTHER CZ BINARY)
        int l=0, r=0, ct=0, sum=0, n=nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int ele:nums){
            sum += ele;
            int rem = sum-goal;
            if (map.containsKey(rem)){
                ct += map.get(rem);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return ct;







        //BRUTE FORCE
        // int n=nums.length, ct=0;
        // for (int i=0; i<n; i++){
        //     int sum=0;
        //     for (int j=i; j<n; j++){
        //         sum += nums[j];
        //         if (sum==goal) ct++;
        //         else if (sum > goal) break;
        //     }
        // }
        // return ct;
    }
}