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
    public int maxPathSum(TreeNode root) {
        return maxPathSumHelper(root).get(0);
    }
    public List<Integer> maxPathSumHelper(TreeNode root) {
        if(root == null) {
            return new ArrayList<>(Arrays.asList(Integer.MIN_VALUE, 0));
        }
        List<Integer> leftTreeStatistics = maxPathSumHelper(root.left);
        List<Integer> rightTreeStatistics = maxPathSumHelper(root.right);

        Integer maxPath = Math.max(leftTreeStatistics.get(0), rightTreeStatistics.get(0));
        maxPath = Math.max(maxPath, leftTreeStatistics.get(1) + rightTreeStatistics.get(1) + root.val);
        Integer partialPath = Math.max(leftTreeStatistics.get(1), rightTreeStatistics.get(1));
        maxPath = Math.max(maxPath, Math.max(partialPath + root.val, root.val));
        return new ArrayList<>(Arrays.asList(maxPath, Math.max(partialPath + root.val, root.val)));
    }
}
