class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i=0; i<n; i++){
            char ch = s.charAt(i);
            if (ch=='(' || ch=='[' || ch=='{') stack.push(ch);
            if (stack.isEmpty()) return false;
            else if (ch==')'){
                char before = stack.pop();
                if (before != '(') return false;
            }
            else if (ch==']'){
                char before = stack.pop();
                if (before != '[') return false;
            }
            else if (ch=='}'){
                char before = stack.pop();
                if (before != '{') return false;
            }
        }  
        if (stack.isEmpty()) return true; 
        return false;
    }
}