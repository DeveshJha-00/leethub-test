class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        // int n = s.length();
        // for (int i=0; i<n; i++){
        //     char c = s.charAt(i);
        //     int ct=1;
        //     int j=i+1;
        //     while (j<n && s.charAt(j)==c){
        //         ct++;
        //         j++;
        //     }
        //     if (ct==k) return true;
        //     i=j-1;
        // }
        // return false;

        int n=s.length();
        if (k==1 && n==1) return true;
        int start=0, end=0;
        if (k==1 && s.charAt(1)!=s.charAt(0)) return true;

        char curr = s.charAt(0);
        for (int i=1; i<n; i++){
            if (s.charAt(i)==curr) end++;
            else{
                curr=s.charAt(i);
                start=i;
                end=i;
            }
            if ((end-start+1)==k){ //found substr of length k
                if (start!=0 && s.charAt(start-1) == curr) continue;
                if (end!=n-1 && s.charAt(end+1) == curr) continue;
                return true;
            }
            // return true;
        }
        return false;
    }
}