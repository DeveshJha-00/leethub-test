class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String prevSorted="";
        for (String word:words){
            char[] characters = word.toCharArray();
            Arrays.sort(characters);
            String currSorted=String.valueOf(characters);
            if ( !prevSorted.equals(currSorted) ) ans.add(word);
            prevSorted = currSorted;
        }
        return ans;
    }
}