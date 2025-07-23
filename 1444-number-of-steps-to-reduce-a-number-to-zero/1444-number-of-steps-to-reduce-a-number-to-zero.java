class Solution {
    public int numberOfSteps(int num) {
        return helper(num,0);
    }
    public int helper(int n, int ans){
        if (n==0) return ans;
        if (n%2==0) return helper(n/2,++ans);
        else return helper(n-1, ++ans);
    }
}