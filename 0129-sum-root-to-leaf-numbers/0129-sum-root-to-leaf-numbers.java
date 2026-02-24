/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        solve(root, "");
        return sum;
    }

    public void solve(TreeNode root, String str){
        if (root==null) return;

        str += String.valueOf(root.val);
        if (root.left==null && root.right==null){
            this.sum += Integer.parseInt(str);
        }else{
            solve(root.left, str);
            solve(root.right, str);
        }

        str = str.substring(0, str.length() - 1);
    }
}