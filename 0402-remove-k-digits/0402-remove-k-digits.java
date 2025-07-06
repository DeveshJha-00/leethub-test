class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (char c : num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek()>c){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while (k>0){
            st.pop(); 
            k--;
        }

        StringBuilder res = new StringBuilder();
        for (char c : st) res.append(c);
        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        
        return res.toString().equals("") ? "0" : res.toString();
    }
}