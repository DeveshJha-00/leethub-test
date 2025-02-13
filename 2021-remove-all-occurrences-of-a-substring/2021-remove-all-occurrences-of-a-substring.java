class Solution {
    public String removeOccurrences(String s, String part) {
        int partLen = part.length();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            ans.append(ch);
            int idx = ans.indexOf(part);
            if (idx==-1) continue;
            else{
                ans.delete(idx, idx+partLen);
            }
        }
        return ans.toString();
    }
}