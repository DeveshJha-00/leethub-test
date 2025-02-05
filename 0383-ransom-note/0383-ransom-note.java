class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] freq = new int[26];

        // for (int i=0; i<magazine.length(); i++){
        //     freq[magazine.charAt(i)-'a']++;
        // }
        // for (int i=0; i<ransomNote.length(); i++){
        //     freq[ransomNote.charAt(i)-'a']--;
        // }
        // for (int ele : freq){
        //     if (ele<0) return false;
        // }
        // return true;

        for (char ch : magazine.toCharArray()) freq[ch-'a']++;
        for (char ch : ransomNote.toCharArray()) freq[ch-'a']--;
        for (int ele : freq){
            if (ele<0) return false;
        }
        return true;
    }
}