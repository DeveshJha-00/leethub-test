class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';

        int len = (int) Math.pow(2,n) - 1;

        if (k == Math.ceil(len/2.0)){
            return '1';
        }

        else if (k < Math.ceil(len/2.0)){
            return findKthBit(n-1, k);
        }
        
        else{
            char flipped = findKthBit(n-1, len-(k-1));
            return (flipped == '0') ? '1' : '0';
        }

    }
}