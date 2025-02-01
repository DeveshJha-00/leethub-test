class Solution {
    public String mostCommonWord(String para, String[] banned) {

        para = para.replaceAll("[^\\sa-zA-Z0-9]", " ").toLowerCase();
        String[] words = para.split("\\s+");
        HashMap<String,Integer> map = new HashMap<>();

        for (String word:words){
            map.put(word, map.getOrDefault(word,0)+1);
        }

        int max=0;
        String ans="";
        for (Map.Entry<String,Integer> ele : map.entrySet()){
            String key = ele.getKey();
            int val = ele.getValue();
            if (val>max && !Arrays.asList(banned).contains(key)){
                ans=key;
                max=val;
            }
            // max=Math.max(max,val);

        }
        return ans;
    }
}