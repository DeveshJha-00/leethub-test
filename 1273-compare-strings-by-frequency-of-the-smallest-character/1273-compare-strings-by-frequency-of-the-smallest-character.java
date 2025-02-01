class Solution {

    public int func(String s){ //frequency of the lexicographically smallest character
        char smallest=s.charAt(0);
        int freq=1;  
        for (int i=1; i<s.length(); i++){
            if (s.charAt(i) == smallest) freq++;
            if (s.charAt(i) < smallest){
                smallest=s.charAt(i);
                freq=1;
            }
        }
        return freq; 
    }

    public boolean isValid(String query, String word){
        return (func(query)<func(word));
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];

        for (int i=0; i<queries.length; i++){
            String query = queries[i];
            int ct=0;
            for (int j=0; j<words.length; j++){
                String word=words[j];
                if (isValid(query,word)) ct++;
            }
            ans[i]=ct;
        }

        return ans;
    }

}