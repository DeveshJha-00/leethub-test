class Solution {

    // public void reverse(StringBuilder sb, int left, int right) {
    //     while (left < right) {
    //         char temp = sb.charAt(left);
    //         sb.setCharAt(left, sb.charAt(right));
    //         sb.setCharAt(right, temp);
    //         left++;
    //         right--;
    //     }
    // }

    // public int nextGreaterElement(int n) {
    //     StringBuilder str = new StringBuilder();
    //     str.append(n);

    //     int i=str.length()-2;
    //     while(i>=0 && str.charAt(i)>=str.charAt(i+1)){
    //         i--;
    //     }
    //     if (i<0) return -1;

    //     int j = str.length()-1;
    //     while (j>i && str.charAt(j)<=str.charAt(i)) {
    //         j--;
    //     }
    //     char temp = str.charAt(i);
    //     str.setCharAt(i, str.charAt(j));
    //     str.setCharAt(j, temp);
    //     reverse(str, i+1, str.length()-1);

    //     long result = Long.parseLong(str.toString());
    //     return (result <= Integer.MAX_VALUE) ? (int) result : -1;
    // }
    
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int i = digits.length-2;

        // Step 1: Find the first decreasing digit from the right
        while (i>=0 && digits[i]>=digits[i+1]) {
            i--;
        }
        if (i<0) return -1; 

        // Step 2: Find the next larger digit to the right of i
        int j = digits.length-1;
        while (j>i && digits[j]<=digits[i]) {
            j--;
        }

        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        Arrays.sort(digits, i+1, digits.length);

        long result = Long.parseLong(new String(digits));
        return (result <= Integer.MAX_VALUE) ? (int) result : -1;
    }
}