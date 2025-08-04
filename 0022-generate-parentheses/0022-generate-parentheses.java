class Solution {
    List<String> res = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        StringBuilder temp = new StringBuilder();
        solve(n, 0, temp);
        return res;
    }
    public void solve(int n, int idx, StringBuilder temp){
        if (idx==2*n){
            if (isValid(temp)) res.add(temp.toString());
            return;
        }
        temp.append("(");
        solve(n, idx+1, temp);
        temp.deleteCharAt(temp.length()-1);
        temp.append(")");
        solve(n, idx+1, temp);
        temp.deleteCharAt(temp.length()-1);
    }
    boolean isValid(StringBuilder s){
        int ctr=0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='(') ctr++;  //Increment balance for '(' 
            else if (ctr>0) ctr--;
            else return false;              // A closing ')' without a matching '('
        }
        
        ctr=0;                              //reset ctr for 2nd reverse pass
        for (int i=s.length()-1; i>=0; i--){
            if (s.charAt(i)==')') ctr++;  //Increment balance for ')' or '*'
            else if (ctr>0) ctr--;
            else return false;              // A closing '(' without a matching ')'
        }

        return true; 
    }
}