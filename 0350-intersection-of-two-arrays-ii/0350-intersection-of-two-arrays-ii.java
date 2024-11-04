class Solution {
    public int[] listToIntArray(List<Integer> list){
        int[] arr = new int[list.size()];
        for(int i=0; i<arr.length; i++){
            arr[i]=list.get(i).intValue();
        }
        return arr;
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();

        //nums1 freq map created
        for (int ele:nums1){
            int val = map.getOrDefault(ele,0);
            map.put(ele,val+1);
        }

        List<Integer> list = new ArrayList<>();

        for (int ele:nums2){
            if (map.containsKey(ele) && map.get(ele)>0){
                list.add(ele);
                map.put(ele, map.get(ele)-1);
                // map.remove(ele);
            }
        }
        int[] res = listToIntArray(list);
        return res;

    }
}