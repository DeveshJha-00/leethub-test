import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer,Integer> map = new HashMap<>();
        int []arr = new int[2];

        arr[0]=arr[1]=-1;
        
        for (int i=0;i<nums.length;i++){
            int value = nums[i];
            int moreneeded = target-value;
            if (map.containsKey(moreneeded)){
                arr[0]=map.get(moreneeded);
                arr[1]=i;
                return arr;
            }
            map.put(value,i);
        }

        return arr;
    }
}