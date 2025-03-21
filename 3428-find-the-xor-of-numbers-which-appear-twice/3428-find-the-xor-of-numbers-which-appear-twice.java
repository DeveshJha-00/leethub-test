class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        //TRADE-OFF QUES
        //APPROACH 1 --> O(N) TIME AND O(N) SPACE
        // HashSet<Integer> set = new HashSet<>();
        // int xor=0;
        // for (int ele:nums){
        //     if (set.contains(ele)){
        //         xor ^= ele;
        //     }
        //     else set.add(ele);
        // }
        // return xor;

        //APPROACH 2 --> O(NLOGN) TIME AND O(1) SPACE
        Arrays.sort(nums);
        int xor=0;
        for (int i=0; i<nums.length-1; i++){
            if (nums[i]==nums[i+1]){
                xor ^= nums[i];
                i++;
            }
        }
        return xor;
    }
}