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
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTreeHelper(root).get(0);
    }
    public List<Integer> diameterOfBinaryTreeHelper(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>(Arrays.asList(0, 0));
        }
        List<Integer> leftTreeStats = new ArrayList<Integer>(Arrays.asList(0, 0));
        List<Integer> rightTreeStats = new ArrayList<Integer>(Arrays.asList(0, 0));
        int leftTreeDepth = 0;
        int rightTreeDepth = 0;
        if(root.left != null) {
            leftTreeStats = diameterOfBinaryTreeHelper(root.left);
            leftTreeDepth = leftTreeStats.get(1) + 1;
        }
        if(root.right != null) {
            rightTreeStats = diameterOfBinaryTreeHelper(root.right);
            rightTreeDepth = rightTreeStats.get(1) + 1;
        }
        int maxSubTreeDiameter = Math.max(leftTreeStats.get(0), rightTreeStats.get(0));
        maxSubTreeDiameter = Math.max(maxSubTreeDiameter, leftTreeDepth + rightTreeDepth);
        return new ArrayList<Integer>(Arrays.asList(maxSubTreeDiameter, Math.max(leftTreeDepth, rightTreeDepth)));
    }    
}
