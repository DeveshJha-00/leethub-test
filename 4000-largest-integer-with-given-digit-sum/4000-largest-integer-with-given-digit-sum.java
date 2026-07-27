class Solution {
    public int largestInteger(int n, int s) {

        if (s == 0) return 0;
        if (s > 9*n) return -1;

        StringBuilder str = new StringBuilder();

        while (n > 0){
            if (s >= 9) {
                str.append('9');
                s -= 9;
            } else{
                str.append((char)(s + '0'));
                s = 0;
            }

            n--; 
        }

        if (s > 0) return -1;   

        return Integer.parseInt(str.toString());
    }
}   