class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int ele:nums) set.add(ele);
        
        int maxLen=0;
        for (int num:set){
            if (!set.contains(num-1)){
                int y=num+1;
                while (set.contains(y)) y++;
                maxLen = Math.max(maxLen, y-num);
            }
        }
        return maxLen;
    }
}