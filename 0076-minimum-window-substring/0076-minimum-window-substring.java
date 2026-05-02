class Solution {
    public String minWindow(String s, String t) {
        int l=0, r=0, startIdx=-1;
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int count = map.size();

        while(r < s.length()){
            if (map.containsKey(s.charAt(r))){
                map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
                if (map.get(s.charAt(r)) == 0) count--;
            }
            
            if (count > 0){
                r++;
            }else if (count == 0){
                while (count == 0){
                    if ((r-l+1) < minLen){
                        minLen = r-l+1;
                        startIdx = l;
                    }
                    if (map.containsKey(s.charAt(l))){
                        map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                        if (map.get(s.charAt(l)) == 1) count++;
                    }
                    l++;
                } 
                r++; 
            }
        }

        if (startIdx == -1) return "";
        return s.substring(startIdx, startIdx + minLen);

    }
}