class Solution {
    public boolean consecutiveSetBits(int n) {
        int cnt = 0;
        int prev = -1;

        while (n > 0){
            int curr = n & 1; 
            n = n >> 1;
            if (prev==1 && curr==1) cnt++;
            prev = curr;
            if (cnt > 1) return false;
        }

        return (cnt == 1);
    }
}