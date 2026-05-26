/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return cloneGraphHelper(node, new HashMap<>());
    }

    public Node cloneGraphHelper(Node node, Map<Node, Node> nodeMapping) {
        if(node == null) {
            return null;
        }
        Node copy = new Node(node.val);
        nodeMapping.put(node, copy);
        for(Node n : node.neighbors) {
            if(nodeMapping.containsKey(n)) {
                copy.neighbors.add(nodeMapping.get(n));
                continue;
            }
            copy.neighbors.add(cloneGraphHelper(n, nodeMapping));
        }
        return copy;
    }

}