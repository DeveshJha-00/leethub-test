class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int maxLen=0;
        // for (int i=0; i<s.length(); i++){
        //    int []hash = new int[256];
        //    for (int j=i; j<s.length(); j++){
        //     if (hash[s.charAt(j)] == 1) break;
        //     int len = j-i+1;
        //     maxLen = Math.max(len, maxLen);
        //     hash[s.charAt(j)]=1;
        //    } 
        // }
        // return maxLen;

        int maxLen=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int left=0, right=0;
        while (right < s.length()){
            if (map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right))+1, left);
            }
            map.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;

    }
}