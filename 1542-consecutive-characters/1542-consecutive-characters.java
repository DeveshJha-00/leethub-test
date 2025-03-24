class Solution {
    public int maxPower(String s) {
        int maxLen=1, currLen=1;
        for(int i=0; i<s.length()-1; i++){
            char ch = s.charAt(i);
            if(s.charAt(i+1) == (ch)) currLen++;
            else currLen=1;
            maxLen = Math.max(currLen, maxLen);
        }
        
        return maxLen;
    }
}