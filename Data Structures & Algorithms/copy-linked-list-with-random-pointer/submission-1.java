/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node newNode = null;
        Node newHead = null;
        Map<Node, List<Node>> randomNodeMap = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node currentNode = new Node(temp.val);            
            if(newNode != null) {
                newNode.next = currentNode;
            }
            if(temp.random != null) {
                List<Node> val = randomNodeMap.getOrDefault(temp.random, new ArrayList<>());
                val.add(currentNode);
                randomNodeMap.put(temp.random, val);
            }
            newNode = currentNode;
            if(newHead == null) {
                newHead = newNode;
            }
            temp = temp.next;
        }
        newNode = newHead;
        while (head != null) {
            if(randomNodeMap.containsKey(head)) {
                for(Node n : randomNodeMap.get(head)) {
                    n.random = newNode;
                }
            }
            head = head.next;
            newNode = newNode.next;
        }
        return newHead;
    }
}
