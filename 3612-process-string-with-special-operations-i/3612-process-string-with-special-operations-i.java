class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()){
            if (Character.isAlphabetic(ch)) res.append(ch);
            else if (ch=='*'){
                if (res.length() >= 1) res.deleteCharAt(res.length()-1);
            }
            else if (ch == '#'){
                res.append(res.substring(0, res.length()));
            }
            else if (ch == '%'){
                res = res.reverse();
            }
        }

        return res.toString();
    }
}