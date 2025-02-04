class Solution {

    public boolean isNumber(String str){
        for (char c : str.toCharArray()){
            if (  c=='-' && str.length()>1 ) continue;
            if (!Character.isDigit(c)) return false;
        }
        return true;

        //OR
        // try{
        //     Integer.parseInt(str);
        //     return true;
        // }catch (NumberFormatException e) {
        //     return false;
        // }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int b,a;
        for (String token : tokens){
            if (isNumber(token)) stack.push(Integer.parseInt(token));
            else{
                switch(token){
                    case "+":
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a+b);
                        break;
                    case "-":
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a-b);
                        break;
                    case "*":
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a*b);
                        break;
                    case "/":
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a/b);
                        break;
                }
            }
        }
        return stack.pop();
    }
}