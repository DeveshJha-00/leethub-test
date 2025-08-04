class Solution {
    List<String> res = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        StringBuilder temp = new StringBuilder();
        solve(n, temp, 0,0);
        return res;
    }
    public void solve(int n, StringBuilder temp, int op, int cl){
        if (op>n || cl>op) return;
        if (temp.length()==2*n){
            if (isValid(temp.toString())) res.add(temp.toString());
            return;
        }
        temp.append("(");
        solve(n, temp, op+1, cl);
        temp.deleteCharAt(temp.length()-1);
        temp.append(")");
        solve(n, temp, op, cl+1);
        temp.deleteCharAt(temp.length()-1);
    }

    boolean isValid(String str){
        int ct=0;
        for (char ch : str.toCharArray()){
            if (ch=='(') ct++;
            else ct--;
            if (ct<0) return false;
        }
        return (ct==0);
    }

}