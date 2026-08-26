class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l=0, r=0, n=s.length();
        int ones=0, zeros=0, minLen=Integer.MAX_VALUE;
        String res = "";

        while(r < n){
            if (s.charAt(r)=='1') ones++;

            while (ones > k || (l<n && s.charAt(l)=='0')){
                if (s.charAt(l)=='1') ones--;
                l++;
            }

            if (ones == k){
                String curr = s.substring(l, r+1);
                int currLen = r-l+1;
                
                if (currLen < minLen){
                    minLen = currLen;
                    res = curr;
                }else if (currLen == minLen){
                    if (curr.compareTo(res) < 0) res=curr;
                }
            }

            r++;
        }

        return res;
    }
}