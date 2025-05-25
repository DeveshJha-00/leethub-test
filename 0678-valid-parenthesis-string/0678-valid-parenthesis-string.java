class Solution {
    public boolean checkValidString(String s) {

    //M1 --> WITH 2 STACKS KEEPING TRACK OF '(' AND '*' SEPARATELY
    // Stack<Integer> leftParen = new Stack<>();
    // Stack<Integer> stars = new Stack<>();
    // for (int i = 0; i < s.length(); i++) {
    //     char ch = s.charAt(i);
    //     if (ch == '(') {
    //         leftParen.push(i);
    //     } else if (ch == '*') {
    //         stars.push(i);
    //     } else if (ch == ')') {
    //         if (!leftParen.isEmpty()) {
    //             leftParen.pop();
    //         } else if (!stars.isEmpty()) {
    //             stars.pop();
    //         } else {
    //             return false; // No matching '(' or '*'
    //         }
    //     }
    // }
    // // Now match any remaining '(' with '*' that comes after it
    // while (!leftParen.isEmpty() && !stars.isEmpty()) {
    //     if (leftParen.pop() > stars.pop()) {
    //         return false; // '*' comes before '(', can't match
    //     }
    // }
    // return leftParen.isEmpty(); 

    //M2 --> KEEPING COUNTER AND HAVING 2 PASSES
    int ctr=0; //keep track of the balance of open parentheses
    if(s.length()==1){
        if (s.charAt(0)=='*') return true;
        return false;
    }
    for (int i=0; i<s.length(); i++){
        char ch = s.charAt(i);
        if (ch=='(' || ch=='*') ctr++;  //Increment balance for '(' or '*'
        else if (ctr>0) ctr--;
        else return false;              // A closing ')' without a matching '('
    }
    
    ctr=0;                              //reset ctr for 2nd reverse pass
    for (int i=s.length()-1; i>=0; i--){
        char ch = s.charAt(i);
        if (ch==')' || ch=='*') ctr++;  //Increment balance for ')' or '*'
        else if (ctr>0) ctr--;
        else return false;              // A closing '(' without a matching ')'
    }

    return true;                        //if ctr not -ve even once after both passes, true

    }
}