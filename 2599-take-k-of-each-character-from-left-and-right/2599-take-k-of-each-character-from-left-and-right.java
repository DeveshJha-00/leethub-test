// class Solution {
//     private int res = Integer.MAX_VALUE;
//     public int takeCharacters(String s, int k) {
//         int n = s.length();
//         int minutes=0, l=0, r=n-1;
//         int[] freq = new int[3];
//         solve(s, k, n, minutes, l, r, freq);
//         return res==Integer.MAX_VALUE ? -1:res;
//     }
//     public void solve(String s, int k, int n, int minutes, int l, int r, int[] freq){
//         if (freq[0]>=k && freq[1]>=k && freq[2]>=k){
//             res = Math.min(res, minutes);
//             return;
//         }
//         if (l>r) return;
//         if (l>n-1) return;
//         if (r<0) return;

//         int[] leftfreq = freq.clone();
//         leftfreq[s.charAt(l)-'a']++;
//         solve(s, k, n, minutes+1, l+1, r, leftfreq);

//         int[] rightfreq = freq.clone();
//         rightfreq[s.charAt(r)-'a']++;
//         solve(s, k, n, minutes+1, l, r-1, rightfreq);
//     }
// }

class Solution{
    public int takeCharacters(String s, int k) {

        int n=s.length();
        int[] freq = new int[3];

        for (char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        if (freq[0]<k || freq[1]<k || freq[2]<k) return -1;

        int l=0, r=0, notDeletedWindowSize=0;

        while (r<n){
            char currChar = s.charAt(r);
            freq[currChar-'a']--;

            while(l<=r && (freq[0]<k || freq[1]<k || freq[2]<k)){
                freq[s.charAt(l)-'a']++;
                l++;
            }
            notDeletedWindowSize = Math.max(notDeletedWindowSize, r-l+1);
            r++;
        }
        
        return n-notDeletedWindowSize;
    }  
}