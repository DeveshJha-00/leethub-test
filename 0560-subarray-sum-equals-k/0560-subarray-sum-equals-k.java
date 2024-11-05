class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count=0, prefSum=0;
        int rem;
        for (int ele:nums){
            prefSum += ele;
            rem = prefSum-k;
            if (map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(prefSum, map.getOrDefault(prefSum,0) + 1);
            // map.put(prefSum,)
        }
        return count;
    }
}