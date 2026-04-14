class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefSum = 0;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>(); //{mod, cnt}
        map.put(0,1);

        for (int num : nums){
            prefSum += num;
            int mod = ((prefSum % k) + k) % k; // for handling -ve mods 
            if (map.containsKey(mod)){
                cnt += map.get(mod);
                map.put(mod, map.get(mod) + 1);
            }else{
                map.put(mod, 1);
            }

        }

        return cnt;
    }
}