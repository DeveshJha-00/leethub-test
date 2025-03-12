class Solution {
    public String minWindow(String s, String t) {

        int n=s.length(), m=t.length(), cnt=0, minLen=Integer.MAX_VALUE, startingIndex=-1;
        int left=0, right=0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<m; i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        while (right<n){
            if (map.getOrDefault(s.charAt(right),0) > 0) cnt++;
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)-1);
            while (cnt==m){
                int len = right-left+1;
                if (len < minLen){
                    minLen=len;
                    startingIndex=left;
                }
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left),0)+1);
                if (map.get(s.charAt(left)) > 0) cnt--;
                left++;
            }
            right++;
        }

        if (startingIndex==-1) return "";
        return s.substring(startingIndex, startingIndex+minLen);
        
    }
}