class Solution {
    public int findMaxK(int[] nums) {
        
        //HASHMAP --> SIMILAR APPROACH AND SLIGHTLY BETTER IS .... HASHSET
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for (int ele:nums){
        //     map.put(ele, map.getOrDefault(ele,0)+1);
        // }
        // int ans = -1;
        // for (int ele:nums){
        //     if (map.containsKey(-ele)){
        //         ans = Math.max(ele,ans);
        //     }
        // }
        // return ans;

        //2 POINTERS 
        Arrays.sort(nums);
        int left=0, right=nums.length-1;
        while (left < right){
            if (-nums[left] > nums[right]){ 
                // no counterpart on +ve side, so shrink from left
                left++;
            }else if (-nums[left] < nums[right]){
                //no counterpart on -ve side, so shrink from right
                right--; 
            }else{
                return nums[right];
            }
        }
        return -1;

    }
}