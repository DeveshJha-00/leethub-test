class Solution {
    public boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) return false;
        String combined = s+s;
        if (combined.indexOf(goal) != -1) return true;
        return false;
    }
}