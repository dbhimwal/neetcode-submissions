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
    public void reorderList(ListNode head) {
        ListNode mid = head;
        if(mid == null) {
            return;
        }
        ListNode temp = head;

        while(temp != null && temp.next != null) {
            mid = mid.next;
            temp = temp.next.next;
        }

        ListNode secondaryHead = reverse(mid.next);
        mid.next = null;

        temp = head;
        while(secondaryHead != null) {
            ListNode next1 = temp.next;
            ListNode next2 = secondaryHead.next;

            temp.next = secondaryHead;
            secondaryHead.next = next1;

            temp = next1;
            secondaryHead = next2;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
