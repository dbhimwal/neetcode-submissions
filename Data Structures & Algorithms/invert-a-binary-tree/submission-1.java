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
    public TreeNode invertTree(TreeNode root) {
        if(root != null) {
            return invertTreeHelper(root);
        }
        return root;
    }
    public TreeNode invertTreeHelper(TreeNode root) {
        if((root.left == null) && (root.right == null)) {
            return root;
        }
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;
        if(leftChild != null) {
            root.right = invertTreeHelper(leftChild);
        } else {
            root.right = null;
        }
        if(rightChild != null) {
            root.left = invertTreeHelper(rightChild);
        } else {
            root.left = null;
        }
        return root;
    }
}
