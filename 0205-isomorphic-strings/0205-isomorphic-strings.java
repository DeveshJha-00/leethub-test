class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        // int n = s.length();
        // HashMap<Character, Integer> sMap = new HashMap<>();
        // HashMap<Character, Integer> tMap = new HashMap<>();
        // for (int i=0; i<n; i++){
        //     sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
        // }
        // for (int i=0; i<n; i++){
        //     tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        // }

        // HashSet<Integer> set1 = new HashSet<>(sMap.values()); 
        // HashSet<Integer> set2 = new HashSet<>(tMap.values());
        // return (set1.equals(set2));

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> mappedValues = new HashSet<>();
        for (int i=0; i<s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (map.containsKey(sChar)){
                if (map.get(sChar) != tChar ) return false;
            }else if (mappedValues.contains(tChar) ) return false;
            
            map.put(sChar, tChar);
            mappedValues.add(tChar);
        }
        return true;
    }   
}