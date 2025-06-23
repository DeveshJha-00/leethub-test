class Solution {
    public int nextGreaterElement(int n) {
        StringBuilder str = new StringBuilder();
        str.append(n);

        int i=str.length()-2;
        while(i>=0 && str.charAt(i)>=str.charAt(i+1)){
            i--;
        }
        if (i<0) return -1;

        int j = str.length()-1;
        while (j>i && str.charAt(j)<=str.charAt(i)) {
            j--;
        }
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
        reverse(str, i+1, str.length()-1);

        long result = Long.parseLong(str.toString());
        return (result <= Integer.MAX_VALUE) ? (int) result : -1;
    }
    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }

}