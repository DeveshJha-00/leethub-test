class Solution {
    public int maximumLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        int maxLen = -1;
        int ones = map.getOrDefault(1, 0);
        if (ones % 2 == 0) maxLen = ones-1;
        else maxLen = ones;

        for (int num : nums){
            if (num == 1) continue;

            int currLen = 0;  

            while (map.getOrDefault(num, 0) > 1){
                currLen += 2;
                num = num * num;
            }
            if (map.containsKey(num)) currLen++;
            else currLen--;

            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}