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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        if(root == null) {
            return result;
        }
        nodes.add(root);
        while(!nodes.isEmpty()) {
            Queue<TreeNode> nextNodes = new LinkedList<>();

            while(!nodes.isEmpty()) {
                TreeNode node = nodes.poll();
                if(nodes.size() == 0) {
                    result.add(node.val);
                }
                if(node.left != null) {
                    nextNodes.add(node.left);
                }
                if(node.right != null) {
                    nextNodes.add(node.right);
                }
            }
            nodes = nextNodes;
        }
        return result;        
    }
}
