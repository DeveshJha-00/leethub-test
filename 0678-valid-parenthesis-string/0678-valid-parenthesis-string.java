class Solution {
    public boolean checkValidString(String s) {
    Stack<Integer> leftParen = new Stack<>();
    Stack<Integer> stars = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (ch == '(') {
            leftParen.push(i);
        } else if (ch == '*') {
            stars.push(i);
        } else if (ch == ')') {
            if (!leftParen.isEmpty()) {
                leftParen.pop();
            } else if (!stars.isEmpty()) {
                stars.pop();
            } else {
                return false; // No matching '(' or '*'
            }
        }
    }

    // Now match any remaining '(' with '*' that comes after it
    while (!leftParen.isEmpty() && !stars.isEmpty()) {
        if (leftParen.pop() > stars.pop()) {
            return false; // '*' comes before '(', can't match
        }
    }

    return leftParen.isEmpty(); 

    }
}