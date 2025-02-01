// class Solution {

//     public int func(String s){ 
//         char smallest=s.charAt(0);
//         int freq=1;  
//         for (int i=1; i<s.length(); i++){
//             if (s.charAt(i) == smallest) freq++;
//             else if (s.charAt(i) < smallest){
//                 smallest=s.charAt(i);
//                 freq=1;
//             }
//         }
//         return freq; 
//     }

//     public int[] numSmallerByFrequency(String[] queries, String[] words) {
//         int[] ans = new int[queries.length];

//         for (int i=0; i<queries.length; i++){
//             String query = queries[i];
//             int ct=0;
//             for (int j=0; j<words.length; j++){
//                 String word=words[j];
//                 if (func(query) < func(word)) ct++;
//             }
//             ans[i]=ct;
//         }
        
//         return ans;
//     }
// }

class Solution {

    public int func(String s) { 
        char smallest = s.charAt(0);
        int freq = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == smallest) freq++;
            else if (s.charAt(i) < smallest) {
                smallest = s.charAt(i);
                freq = 1;
            }
        }
        return freq;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordFreq = new int[words.length];
        
        // Precompute frequency values for words
        for (int i = 0; i < words.length; i++) {
            wordFreq[i] = func(words[i]);
        }

        Arrays.sort(wordFreq); // Sort to enable binary search
        
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int queryFreq = func(queries[i]);

            // Binary search for the first index where wordFreq[j] > queryFreq
            int count = wordFreq.length - binarySearch(wordFreq, queryFreq);
            ans[i] = count;
        }

        return ans;
    }

    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) right = mid;
            else  left = mid + 1;
        }
        return left;
    }
}
