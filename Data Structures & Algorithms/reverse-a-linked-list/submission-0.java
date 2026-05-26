/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode currentNode = head;
        if(currentNode == null) {
            return currentNode;
        }
        ListNode nextNode = currentNode.next;
        currentNode.next = null;

        while(nextNode != null) {
            ListNode tempNode = nextNode.next;
            nextNode.next = currentNode;
            currentNode = nextNode;
            nextNode = tempNode;
        }
        return currentNode;
    }
}
