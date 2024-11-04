class Solution {

    public int[] listToIntArray(List<Integer> list){
        int[] arr = new int[list.size()];
        for (int i=0; i < arr.length; i++){
            arr[i] = list.get(i).intValue();
        }
        return arr;
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        //USING HASHMAP -->3ms
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int ele:nums1){
            int val = map.getOrDefault(ele,0);
            map.put(ele,val+1);
        }
        List<Integer> list = new ArrayList<>();
        for (int ele:nums2){
            if (map.containsKey(ele)){
                list.add(ele);
                map.remove(ele);
            }
        }
        //arraylist to int array
        int[] res = listToIntArray(list);
        return res;



        //USING SET --> 3ms
        // Set<Integer> set1 = new HashSet<>();
        // Set<Integer> set2 = new HashSet<>();
        // for (int ele : nums1){
        //     set1.add(ele);
        // }
        // for (int ele:nums2){
        //     set2.add(ele);
        // }
        // set1.retainAll(set2);
        
        // int[] res = new int[set1.size()];
        // int i=0;
        // for (int ele:set1){
        //     res[i++] = ele;
        // }
        // return res;

    }
}