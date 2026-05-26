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
    TreeNode LCA = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorHelper(root, p, q);
        return LCA;
    }
    public int lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return 0;
        }
        if (LCA != null) {
            return 2;
        }
        int leftNodeValues = lowestCommonAncestorHelper(root.left, p, q);
        int rightNodeValues = lowestCommonAncestorHelper(root.right, p, q);
        int nodeVale = 0;
        if(root.val == p.val || root.val == q.val) {
            nodeVale = 1;
        }
        int currentValue = leftNodeValues + rightNodeValues + nodeVale;
        if(LCA == null && currentValue == 2) {
            // System.out.println("root: " + root.val);
            LCA = root;
        }
        return currentValue;
    }    
}
