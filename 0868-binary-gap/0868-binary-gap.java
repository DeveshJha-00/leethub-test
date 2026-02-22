class Solution {
    public int binaryGap(int n) {
        // int bits = Integer.bitCount(n);
        // if (bits == 1) return 0;
        int maxDist = 0, cnt = 0, last = Integer.MAX_VALUE;

        while (n != 0){
            int bit = n & 1;
            if (bit == 1){
                maxDist = Math.max(maxDist, cnt - last);
                last = cnt;
            }
            n = n >> 1;
            cnt++;
        }

        // last 0 , cnt 3
        return maxDist;
    }
}