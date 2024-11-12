class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder("");

        // int op=0, cl=0;
        // for (int i=0; i<s.length(); i++){
        //     int bracket = s.charAt(i);
        //     if (bracket == '(') op++;
        //     else cl++;
        //     if (op==cl){
        //         for (int j=0; j<op-1; j++){
        //             ans.append('(');
        //             ans.append(')');
        //         }
        //         op=0;
        //         cl=0;
        //     }
        // }

        int count=0, flag=0;
        for (int i=0; i<s.length(); i++){
            char bracket = s.charAt(i);
            if (bracket == '(' && count==0){
                flag=i;
                count++;
            }
            else if (bracket == '(') count++;
            else count--;
            if (count==0){
                ans.append(s.substring(flag+1,i));
            }
        }


        return ans.toString();
    }
}