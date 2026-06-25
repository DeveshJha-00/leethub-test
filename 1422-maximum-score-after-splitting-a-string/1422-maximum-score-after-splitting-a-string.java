class Solution {
    public int maxScore(String s) {
        int zeros=0, ones=0;
        for (char ch : s.toCharArray()){
            if (ch=='1') ones++;
        }

        int maxScore = 0;
        for (int i=0; i<s.length()-1; i++){
            if (s.charAt(i) == '0') zeros++;
            else ones--;
            int currScore = ones+zeros;
            maxScore = Math.max(maxScore, currScore);
        }

        return maxScore;
    }
}