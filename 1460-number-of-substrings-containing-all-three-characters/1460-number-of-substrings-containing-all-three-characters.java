class Solution {
    public int numberOfSubstrings(String s) {
        // int ct=0, n=s.length();
        // for (int i=0; i<n; i++){
        //     int[] hash = new int[3];
        //     for (int j=i; j<n; j++){
        //         hash[s.charAt(j)-'a']=1;
        //         if (hash[0]+hash[1]+hash[2] == 3){
        //             ct += (n-j);
        //             break; 
        //         }
        //     }
        // }
        // return ct;

        int ct=0, n=s.length();
        int[] lastSeen = {-1, -1, -1};
        for (int i=0; i<n; i++){
            lastSeen[s.charAt(i)-'a']=i;
            if (lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
                 int minIndex = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                ct += 1+minIndex;
            }
        }
        return ct;
    }
}