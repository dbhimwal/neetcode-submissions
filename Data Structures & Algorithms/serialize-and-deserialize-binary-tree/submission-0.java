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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            TreeNode currentNode = nodes.poll();
            if(currentNode != null) {
                result.append(Integer.toString(currentNode.val)).append("#");
                nodes.add(currentNode.left);
                nodes.add(currentNode.right);
            } else {
                result.append("n").append("#");
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode parentNode = null;
        Boolean nodeCompleted = false;
        TreeNode root = null;
        System.out.println(data);
        for(int i = 0; i < data.length(); i++) {
            int currentValue = 0;
            while(i < data.length() && data.charAt(i) != '#') {
                if(data.charAt(i) == 'n') {
                    if(nodeCompleted) {
                        parentNode = nodes.poll();
                    }
                    nodeCompleted = !nodeCompleted;
                    i++;
                }
                else if(data.charAt(i) == '-') {
                    currentValue = currentValue * 10 - (data.charAt(i++) - '0');
                } else {
                    currentValue = currentValue * 10 + (data.charAt(i) - '0');
                }
                i++;
            }
            if(i == data.length()) {
                break;
            }
            System.out.println(currentValue);
            TreeNode currentNode = new TreeNode(currentValue);
            nodes.add(currentNode);
            if(parentNode == null) {
                parentNode = nodes.poll();
                nodeCompleted = false;
                root = parentNode;
            }
            else if(!nodeCompleted) {
                parentNode.left = currentNode;
                nodeCompleted = true;
            } else {
                parentNode.right = currentNode;
                parentNode = nodes.poll();
                nodeCompleted = false;
            }
        }
        return root;
    }
}
