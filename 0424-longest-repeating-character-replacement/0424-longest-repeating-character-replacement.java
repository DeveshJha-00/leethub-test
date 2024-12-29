class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, r=0, maxLen=0, n=s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        // while (r<n){
        //     char currChar = s.charAt(r);
        //     map.put(currChar, map.getOrDefault(currChar, 0)+1);
        //     if (map.size() > 1 && map.get(currChar)>k){
        //         l=r;
        //     }
        //     // if (map.size() <= k){
        //     maxLen = Math.max(maxLen, r-l+1);
        //     // }
        //     r++;
        // }
        
        // for (int i=0; i<n; i++){
        //     int[] hash = new int[26];
        //     int maxf=0, changes=0;
        //     for (int j=0; j<n; j++){
        //         hash[s.charAt(j)-'A']++;
        //         maxf = Math.max(maxf, hash[s.charAt(j)-'A']);
        //         changes = (j-i+1) - maxf;
        //         if (changes <= k){
        //             maxLen = Math.max(maxLen, j-i+1);
        //         }else{
        //             break;
        //         }
        //     }
        // }

        int maxFreq=0;
        while (r<n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));
            int changes = (r-l+1) - maxFreq;
            while (changes > k){ //trim from left (not valid)
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                //update new maxFreq
                l++;
                maxFreq = (Collections.max(map.values()));
                changes = (r-l+1) - maxFreq;
            }
            if (changes <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }

        return maxLen;
    }
}