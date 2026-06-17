/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();

        findPath(root, p, pathP);
        findPath(root, q, pathQ);

        TreeNode ans = null;
        int n = Math.min(pathP.size(), pathQ.size());

        for (int i = 0; i < n; i++) {
            if (pathP.get(i) == pathQ.get(i)) ans = pathP.get(i);
            else break;
        }

        return ans;
    }

    private boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) return false;

        path.add(root);

        if (root == target) return true;

        if (findPath(root.left, target, path) || findPath(root.right, target, path))
            return true;

        path.remove(path.size() - 1);

        return false;
    }
    
}