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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode rightNode = head;
        for(int i = 0; i < n; i++) {
            rightNode = rightNode.next;
        }
        ListNode leftNode = head; // 1 - 3
        if(rightNode == null) {
            return head.next;
        }
        while(rightNode.next != null) {
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        leftNode.next = leftNode.next.next;
        return head;
    }
}
