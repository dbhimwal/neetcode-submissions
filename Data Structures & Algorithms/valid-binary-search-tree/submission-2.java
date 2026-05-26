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
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return isValid;
    }

    public boolean isValidBSTHelper(TreeNode root, int lowerBound, int upperBound) {
        if(root == null) {
            return isValid;
        }
        if(!isValid) {
            return isValid;
        }
        if(root.val >= upperBound) {
            isValid = false;
            return isValid;
        }
        if(root.val <= lowerBound) {
            isValid = false;
            return isValid;
        }
       return isValidBSTHelper(root.left, lowerBound, root.val) && isValidBSTHelper(root.right, root.val, upperBound);
    }
}
