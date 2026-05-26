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
    public int goodNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return goodNodesHelper(root, root.val);
    }
    public int goodNodesHelper(TreeNode root, int max) {
        int goodNodes = 0;
        if(root.val >= max) {
            goodNodes = 1;
            max = root.val;
        }
        if(root.left != null) {
            goodNodes +=  goodNodesHelper(root.left, max);
        }
        if(root.right != null) {
            goodNodes +=  goodNodesHelper(root.right, max);
        }
        return goodNodes;
    }
}
