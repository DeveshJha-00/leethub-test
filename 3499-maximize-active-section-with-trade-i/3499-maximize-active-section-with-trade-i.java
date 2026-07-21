class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        List<Integer> zeroBlockLen = new ArrayList<>();
        int zeros = 0, ones = 0;

        // for (int i=0; i<n; i++){
        //     if (s.charAt(i) == '0') zeros++;
        //     else{
        //         ones++;
        //         zeroBlockLen.add(zeros);
        //         zeros = 0;
        //     }
        // } 
        // zeroBlockLen.add(zeros);

        int i=0;
        while (i < n){
            if (s.charAt(i) == '0'){
                int start = i;
                while (i<n && s.charAt(i)=='0') i++;
                zeroBlockLen.add(i - start);
            }else{
                ones++;
                i++;
            }
        }

        System.out.println(zeroBlockLen);
        int maxLen = 0;
        for (int j=1; j<zeroBlockLen.size(); j++){
            int currMax = zeroBlockLen.get(j) + zeroBlockLen.get(j-1);
            maxLen = Math.max(maxLen, currMax);
        }
        
        return maxLen + ones;
    }
}

