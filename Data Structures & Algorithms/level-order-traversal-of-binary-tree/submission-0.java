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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        if(root == null) {
            return result;
        }
        nodes.add(root);
        while(!nodes.isEmpty()) {
            Queue<TreeNode> nextNodes = new LinkedList<>();
            List<Integer> nodeList = new ArrayList<>();

            while(!nodes.isEmpty()) {
                TreeNode node = nodes.poll();
                nodeList.add(node.val);
                if(node.left != null) {
                    nextNodes.add(node.left);
                }
                if(node.right != null) {
                    nextNodes.add(node.right);
                }
            }
            result.add(nodeList);
            nodes = nextNodes;
        }
        return result;
    }
}
