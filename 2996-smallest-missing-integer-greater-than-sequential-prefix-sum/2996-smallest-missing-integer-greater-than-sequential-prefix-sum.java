class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num :nums) set.add(num);

        int sum = nums[0];
        int idx = 1;
        while(idx < nums.length && nums[idx]==nums[idx-1] + 1){
            sum += nums[idx];
            idx++;
        }

        while(set.contains(sum)){
            sum ++;
        }

        return sum;
    }
}