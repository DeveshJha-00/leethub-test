class Solution {
    public int maximumLengthSubstring(String s) {
        int l=0, r=0, n=s.length();
        int maxLen = -1;
        int[] freq = new int[26];

        while (r < n){
            freq[s.charAt(r)-'a']++;
            
            while (freq[s.charAt(r)-'a'] > 2){
                freq[s.charAt(l)-'a']--;
                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }

        return maxLen;
    }
}