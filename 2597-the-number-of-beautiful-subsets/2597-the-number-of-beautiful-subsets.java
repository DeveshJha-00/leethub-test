class Solution {
    private int cnt = 0;

    public void dfs(int[] nums, int idx, Map<Integer, Integer> map, int k){
        if (idx == nums.length){
            cnt++;
            return;
        }

        dfs(nums, idx+1, map, k); //not take

        if (!map.containsKey(nums[idx] - k) && !map.containsKey(nums[idx] + k)){ //take
            map.put(nums[idx], map.getOrDefault(nums[idx],0) + 1);
            dfs(nums, idx+1, map, k);
            map.put(nums[idx], map.get(nums[idx]) - 1);

            if (map.get(nums[idx]) == 0) map.remove(nums[idx]);
        }
    }

    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(nums, 0, map, k);
        return cnt-1;
    }
}