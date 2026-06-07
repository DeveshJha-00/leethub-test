// take block of consecutive ones (-1 idx also if exists)
// if block size == total str size like nums=[3,2] and s="11", return total 
// else remove min from that range and add to total
// for sum and min in range [l, r] use prefSum or TLE

class Solution {
    public long maxTotal(int[] nums, String s) {
        int n = s.length();
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + nums[i];
        }
        //sum(l,r) = pref(r+1) - pref(l)

        //find [l,r]
        long res = 0;
        int i = 0;
        while (i < n){
            if (s.charAt(i) == '0'){
                i++;
                continue;
            }

            int left = i;
            while (i<n && s.charAt(i)=='1') i++;
            int right = i-1;

            if (left == 0){ //entire [0,r] should be included 
                res += pref[right+1] - pref[0];
            }else{ //need sum(l-1,r) - min(l,r)
                long sum = pref[right+1] - pref[left-1];
                int minEle = Integer.MAX_VALUE;
                for (int k=left-1; k<=right; k++){
                    minEle = Math.min(minEle, nums[k]);
                }

                res += sum - minEle;
            }
        }
    
        return res;
    }
}