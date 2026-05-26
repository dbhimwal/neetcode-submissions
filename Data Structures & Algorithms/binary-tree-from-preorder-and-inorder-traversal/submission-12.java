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
    int preOrderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int startIndex, int endIndex) {
        System.out.println(startIndex + ":" + endIndex);
        if(endIndex < startIndex) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preOrderIndex++]);
        if(endIndex == startIndex) {
            return root;
        }
        
        int index = startIndex;
        for(int i = startIndex; i <= endIndex; i++) {
            if(inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        
        root.left = buildTreeHelper(preorder, inorder, startIndex, index - 1);
        root.right = buildTreeHelper(preorder, inorder, index + 1, endIndex);
        return root;
    }

}
