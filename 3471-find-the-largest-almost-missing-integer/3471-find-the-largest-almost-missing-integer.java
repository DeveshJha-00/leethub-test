class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int l=0, r=0;

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        while (r < n) {
            if (r-l+1 == k){

                for (int i = l; i <= r; i++) {
                    set.add(nums[i]);
                }

                for (int x : set) {
                    map.put(x, map.getOrDefault(x, 0) + 1);
                }

                set.remove(nums[l]);
                l++;
            }
            r++;
        }

        int result = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count == 1 && num > result) result = num;
        }

        return result;
    }
}