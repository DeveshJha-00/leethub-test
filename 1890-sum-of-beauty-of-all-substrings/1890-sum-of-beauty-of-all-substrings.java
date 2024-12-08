class Solution {

    // public int beauty(String s){
    //     int[] arr = new int[26];
    //     for (int i=0; i<s.length(); i++){
    //         char c = s.charAt(i);
    //         arr[c-'a']++;
    //     }

    //     int max = Integer.MIN_VALUE;
    //     int min = Integer.MAX_VALUE;
    //     for (int i=0; i<26; i++){
    //         if (arr[i]>0){
    //             max = Math.max(max, arr[i]);
    //             min = Math.min(min, arr[i]);
    //         }
    //     }
    //     return (max-min);
    // }

    public int beautySum(String s) {
        // //generate all substrgs and add each's beauty
        // int totBeauty = 0;
        // for (int i=0; i<s.length(); i++){
        //     for (int j=i; j<s.length(); j++){
        //         String substr = s.substring(i,j+1);
        //         totBeauty += beauty(substr);
        //     }
        // }
        // return totBeauty;

        //WAYY OPTIMIZED -->
        int totBeauty = 0;
        for (int i=0; i<s.length(); i++){
            int[] arr = new int[26];
            for (int j=i; j<s.length(); j++){
                arr[s.charAt(j)-'a']++;

                //now find beauty of current substr and add
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int k=0; k<26; k++){
                    if (arr[k] > 0){
                        max = Math.max(max, arr[k]);
                        min = Math.min(min, arr[k]);
                    }
                }
                totBeauty += (max-min);   
            }
        }

        return totBeauty;
    }
}