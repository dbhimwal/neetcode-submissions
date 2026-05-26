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
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        int height = height(root);
        return balanced;
    }

    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int maxHeight = Math.max(leftHeight, rightHeight);
        if(balanced && (maxHeight - 1 <= leftHeight) && (maxHeight - 1 <= rightHeight)) {
            balanced = true;
        } else {
            balanced = false;
        }
        return maxHeight + 1;
    }
}
