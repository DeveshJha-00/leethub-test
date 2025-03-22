class Solution {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int ele:nums) set.add(ele);
        int maxLen=0;

        for (int num:set){
            if (!set.contains(num-1)){ //start of the seq
                int limit=num+1;
                while (set.contains(limit)) limit++;
                maxLen = Math.max(maxLen, limit-num);
            }
        }
        return maxLen;

    }
}