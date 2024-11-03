class Solution {
    public boolean isAnagram(String str1, String str2) {

        if (str1.length()!=str2.length()) return false;

        // HashMap<Character,Integer> map1 = new HashMap<>();
        // HashMap<Character,Integer> map2 = new HashMap<>();
        
        // for(int i=0;i<str1.length();i++){
        //     char ch = str1.charAt(i);
        //     int val = map1.getOrDefault(ch, 0);
        //     map1.put(ch,val+1);
        // }
        // for(int i=0;i<str2.length();i++){
        //     char ch = str2.charAt(i);
        //     int val = map2.getOrDefault(ch, 0);
        //     map2.put(ch,val+1);
        // }

        // for(int i=0;i<str1.length();i++){
        //     if (map1.get(str1.charAt(i))!=map2.get(str1.charAt(i))) return false;
        // }

        // return true;
        
        int[] charCount = new int[26];
        for (int i=0;i<str1.length();i++){
            charCount[str1.charAt(i) - 'a']++;
            charCount[str2.charAt(i) - 'a']--;
        }
        for (int ele:charCount){
            if (ele!=0) return false;
        }
        return true;
    }
}