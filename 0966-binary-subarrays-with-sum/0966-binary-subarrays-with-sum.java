class Solution {
    public int atmostkoddnum(int[] nums, int goal){
        if (goal<0) return 0; //for fun(nums,goal-1) if goal==0 initally 
        int l=0, r=0, ct=0, sum=0, n=nums.length;
        while (r<n){
            sum += nums[r];
            while (sum > goal){
                sum -= nums[l];
                l++;
            }
            ct += r-l+1;
            r++;
        }
        return ct;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        //COUNT SUBBARAYS WITH SUM=K APPROACH (CAN BE OPTIMIZED FUTHER CZ BINARY)
        // int l=0, r=0, ct=0, sum=0, n=nums.length;
        // HashMap<Integer,Integer> map = new HashMap<>();
        // map.put(0,1);
        // for(int ele:nums){
        //     sum += ele;
        //     int rem = sum-goal;
        //     if (map.containsKey(rem)){
        //         ct += map.get(rem);
        //     }
        //     map.put(sum, map.getOrDefault(sum,0)+1);
        // }
        // return ct;

        //FIND SUBARRAYS WITH SUM<=K AND THEN DO fun(nums,goal)-fun(nums,goal-1);
        return atmostkoddnum(nums,goal)-atmostkoddnum(nums,goal-1);
        

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