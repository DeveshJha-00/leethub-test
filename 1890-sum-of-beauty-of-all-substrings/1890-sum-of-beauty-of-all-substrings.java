class Solution {

    public int beauty(String s){
        // HashMap<Character,Integer> map = new HashMap<>();
        // for (char c : str.toCharArray()){
        //     map.put(c, map.getOrDefault(c,0)+1);
        // }
        // int max=Integer.MIN_VALUE;
        // int min=Integer.MAX_VALUE;
        // for (int value : map.values()){
        //     if (value > max) max = value;
        //     if (value < min) min = value;
        // }
        // return (max-min);
        int[] arr = new int[26];
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            arr[c-'a']++;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<26; i++){
            if (arr[i]>0){
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }
        }
        return (max-min);
    }

    public int beautySum(String s) {
        //generate all substrgs and add each's beauty
        int totBeauty = 0;
        for (int i=0; i<s.length(); i++){
            for (int j=i; j<s.length(); j++){
                String substr = s.substring(i,j+1);
                totBeauty += beauty(substr);
            }
        }
        return totBeauty;
    }
}