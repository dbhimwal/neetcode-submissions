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
    Map<TreeNode, Map<Boolean, Integer>> memory = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return robHelper(root, false);
    }

    public int robHelper(TreeNode node, boolean parentIncluded) {
        if(node == null) {
            return 0;
        }
        if(memory.containsKey(node)) {
            if(memory.get(node).containsKey(parentIncluded)) {
                return memory.get(node).get(parentIncluded);
            }
        }
        // System.out.println(node.val + "-" + parentIncluded);

        int sumCurrentNodeNotIncluded = 0;
        int sumCurrentNodeIncluded = node.val;
        sumCurrentNodeNotIncluded = robHelper(node.left, false) + robHelper(node.right, false);

        sumCurrentNodeIncluded += robHelper(node.left, true) + robHelper(node.right, true);

        Map<Boolean, Integer> value = new HashMap<>();
        int answer;
        if (parentIncluded) {
            answer = sumCurrentNodeNotIncluded;
        } else {
            answer = Math.max(sumCurrentNodeNotIncluded, sumCurrentNodeIncluded);
        }

        memory.putIfAbsent(node, new HashMap<>());
        memory.get(node).put(parentIncluded, answer);

        return answer;
    }
}