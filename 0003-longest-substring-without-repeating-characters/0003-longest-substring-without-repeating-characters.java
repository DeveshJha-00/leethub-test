class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0, r=0, n=s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        while(r < n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0) + 1);

            while (map.get(s.charAt(r)) > 1){
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l),0) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);

            r++;
        }

        return maxLen;
    }
}