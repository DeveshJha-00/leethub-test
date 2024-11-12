class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder ans = new StringBuilder(strs[0]);
        int noOfWords = strs.length;

        for (int i=1; i<noOfWords; i++){
            String word = strs[i];
            int len = Math.min(ans.length(), word.length());
            // for (int j=0; j<len; j++){
            //     if (word.charAt(j) != ans.charAt(j)) ans.deleteCharAt(j);
            // }
            int j = 0;
            while (j < len && ans.charAt(j) == word.charAt(j)) {
                j++;
            }
            ans.setLength(j); 
        }

        return ans.toString();
    }
}