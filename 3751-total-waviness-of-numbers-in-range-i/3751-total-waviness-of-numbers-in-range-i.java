class Solution {
    public int totalWaviness(int num1, int num2) {
        int res = 0;
        for (int i=num1; i<=num2; i++){
            res += contri(i);
        }

        return res;
    }

    private int contri(int n){
        String num = Integer.toString(n); 
        if (num.length() <= 2) return 0;

        int res = 0;
        for (int i=1; i<num.length()-1; i++){
            int left = num.charAt(i-1);
            int curr = num.charAt(i);
            int right = num.charAt(i+1);
            if ((curr>left && curr>right) || (curr<left && curr<right)) res++; 
        }
        return res;
    }
}