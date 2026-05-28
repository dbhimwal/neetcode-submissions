/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        int gridLength = grid.length;
        return constructHelper(grid, 0, 0, gridLength);
    }

    private Node constructHelper(int[][] grid, int startHorizontal, int startVertical, int length) {
        if(length == 1) {
            boolean val = grid[startHorizontal][startVertical] == 1;
            return new Node(val, true);
        } else {
            Node root = new Node(false, false);
            root.topLeft = constructHelper(grid, startHorizontal, startVertical, length/2);
            root.topRight = constructHelper(grid, startHorizontal, startVertical  + length/2, length/2);
            root.bottomLeft = constructHelper(grid, startHorizontal  + length/2, startVertical, length/2);
            root.bottomRight = constructHelper(grid, startHorizontal + length/2, startVertical + length/2, length/2);
            if(root.topLeft.isLeaf && root.topRight.isLeaf && root.bottomLeft.isLeaf && root.bottomRight.isLeaf) {
                if(root.topLeft.val && root.topRight.val && root.bottomLeft.val && root.bottomRight.val) {
                    return new Node(root.topLeft.val, true);
                }
                if(!root.topLeft.val && !root.topRight.val && !root.bottomLeft.val && !root.bottomRight.val) {
                    return new Node(root.topLeft.val, true);
                }
            }
            return root;
        }
    }
}