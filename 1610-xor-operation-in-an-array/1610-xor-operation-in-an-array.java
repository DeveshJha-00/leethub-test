class Solution {

    public int xorTillN(int n) {
        switch (n % 4) {
            case 0: return n;
            case 1: return 1;
            case 2: return n + 1;
            case 3: return 0;
            default: return 0;
        }
    }

    public int xorOperation(int n, int start) {
        int xor=0;
        for (int i=0; i<n; i++) {
            xor ^= (start + 2*i);
        }
        return xor;
    }

}