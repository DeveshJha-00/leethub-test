class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int mini= (int)(n/3) + 1;
        for (int ele:nums){
            map.put(ele, map.getOrDefault(ele,0)+1);
            if (map.get(ele) == mini){
                list.add(ele);
            }
            if (list.size() == 2) break;
        }
        return list;
    }
}