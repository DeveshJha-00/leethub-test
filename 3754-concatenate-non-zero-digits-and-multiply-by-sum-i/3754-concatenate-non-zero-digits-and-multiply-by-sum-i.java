class Solution {
    public long sumAndMultiply(int n) {
        long res = 0;
        long sum = 0, x = 0;
        
        for (char ch : String.valueOf(n).toCharArray()){
            if (ch == '0') continue;

            res = (res * 10) + ch-'0';
            sum += ch-'0';
        }

        return res*sum;
    }
}