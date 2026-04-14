class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer> map = new HashMap<>(); //{prefSum, cnt}
        map.put(0, -1);

        int maxLen=0, currSum=0;
        
        for (int i=0; i<n; i++){
            currSum += (nums[i] == 1) ? 1 : -1;
            if (map.containsKey(currSum)){
                int currLen = i - map.get(currSum);
                maxLen = Math.max(maxLen, currLen);
            }else{
                map.put(currSum, i);
            }
        }

        return maxLen;
    }
}