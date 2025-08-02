class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i=0; i<n-2; i++){
        //     for (int j=i+1; j<n-1; j++){
        //         for (int k=j+1; k<n; k++){
        //             int sum = nums[i]+nums[j]+nums[k];
        //             int diff = Math.abs(target-sum);
        //             map.put(diff,sum);
        //         }
        //     }
        // }
        // int minDiff=target;
        // for (Map.Entry<Integer, Integer> e : map.entrySet()){
        //     minDiff = Math.min(minDiff, e.getKey());
        // }
        // return map.get(minDiff);
        //[-1,2,1,4]
        //[-1,1,2,4]
        //{diff,sum}
        //{1:2,4:5,6:7}

        Arrays.sort(nums);
        int minSum = nums[0]+nums[1]+nums[2];
        for (int i=0; i<n-2; i++){
            int l=i+1; 
            int r=n-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if (sum==target) return sum;
                int currDiff = Math.abs(target-sum);
                int minDiff = Math.abs(target-minSum);
                if (currDiff < minDiff){
                    minSum=sum;
                } 
                if (sum < target) l++;
                else r--;
            }
        }
        return minSum;
    }
}