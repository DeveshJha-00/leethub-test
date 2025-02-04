class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();

        String[] words=s.split(" ");
        if (pattern.length() != words.length) return false;
        int n = pattern.length();

        for (int i=0; i<n; i++){
            char ch = pattern.charAt(i);
            String word=words[i];
            if (map.containsKey(ch) && !map.get(ch).equals(word)) return false;
            if (!map.containsKey(ch) && map.containsValue(word)) return false;
            else map.put(ch, word);
        }
        return true;
    }
}