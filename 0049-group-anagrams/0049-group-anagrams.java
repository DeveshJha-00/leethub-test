class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
         Map<String, Integer> map = new HashMap<>();

         for (int i=0; i<strs.length; i++){
            String word=strs[i];
            String key = getCode(word);

            if (map.containsKey(key)){ //add in existing sub-list
                int val=map.get(key);
                ans.get(val).add(word);
            }else{
                map.put(key, ans.size()); //create new sub-list
                List<String> newGroup = new ArrayList<>();
                newGroup.add(word);  
                ans.add(newGroup);
            }
         }

        return ans;
    }
    public String getCode(String word){
        StringBuilder code = new StringBuilder();
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) freq[ch-'a']++;
        for (int i=0; i<26; i++){
            code.append(freq[i]);
            code.append('#');
        }
        return code.toString();
    }
}