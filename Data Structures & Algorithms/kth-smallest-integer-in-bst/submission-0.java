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
    Integer kthValue = null;
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return kthValue;
    }

    public int kthSmallestHelper(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }
        if(kthValue != null) {
            return 0;
        }
        int leftTreeNodes = kthSmallestHelper(root.left, k);
        if(kthValue == null && leftTreeNodes + 1 == k) {
            kthValue = root.val;
        }
        int rightTreeNodes = kthSmallestHelper(root.right, k - leftTreeNodes - 1);
        return leftTreeNodes + 1 + rightTreeNodes;
    }
}
