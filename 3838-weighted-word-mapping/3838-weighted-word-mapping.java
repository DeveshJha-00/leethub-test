class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res = new StringBuilder();

        for (String word : words){
            int total = 0;
            for (char ch : word.toCharArray()){
                total += weights[ch-'a'];
            }
            total %= 26;
            res.append((char)('z'-total));
        }
        
        return res.toString();
    }
}