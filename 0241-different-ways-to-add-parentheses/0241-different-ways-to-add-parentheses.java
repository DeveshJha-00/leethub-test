class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }

    private List<Integer> solve(String s){
        List<Integer> res = new ArrayList<>();

        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if (ch=='+' || ch=='-' || ch=='*'){
                List<Integer> leftResults = solve(s.substring(0, i));
                List<Integer> rightResults = solve(s.substring(i + 1));

                for (int x : leftResults) {
                    for (int y : rightResults) {
                        if (ch == '+') res.add(x + y);
                        else if (ch == '-') res.add(x-y);
                        else res.add(x * y);
                    }
                }
            }

        }

        if (res.isEmpty()) {
            res.add(Integer.parseInt(s));
        }
        
        return res;
    }
}