class Solution {
    // public String shiftingLetters(String s, int[] shifts) {
    //     int n = s.length();
    //     long[] diff = new long[n];

    //     for (int i = 0; i<n; i++){
    //         diff[i] = shifts[i];
    //     }

    //     for (int i=n-2; i>=0; i--){
    //         diff[i] += diff[i + 1];
    //     }


    //     StringBuilder res = new StringBuilder(s);
    //     for (int i=0; i<n; i++){
    //         int shift = (int)diff[i]%26;
    //         if (shift<0) shift+=26;
    //         int oldCharVal = res.charAt(i)-'a';
    //         char newChar = (char)((oldCharVal+shift)%26 + 'a');
    //         res.setCharAt(i, newChar);
    //     }

    //     return res.toString();
    // }

    public String shiftingLetters(String s, int[] shifts) {
    int n = s.length();
    long totalShift = 0;

    StringBuilder res = new StringBuilder(s);

    // Traverse from right to left applying cumulative shift
    for (int i = n - 1; i >= 0; i--) {
        totalShift = (totalShift + shifts[i]) % 26;
        int oldCharVal = res.charAt(i) - 'a';
        char newChar = (char)((oldCharVal + totalShift) % 26 + 'a');
        res.setCharAt(i, newChar);
    }

    return res.toString();
}

}