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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nextHead = head;
        ListNode result = null;
        ListNode prevHead = head;
        ListNode oldHead = null;
        ListNode prevEnd = null;
        while(nextHead != null) {
            int i = 0;
            while (i < k) {
                if(nextHead != null) {
                    nextHead = nextHead.next;
                    i++;
                } else {
                    break;
                }
            }
            if(nextHead != null) {
                System.out.println("reversing till: " + nextHead.val + " i: " + i);
            } else { 
                System.out.println("reversing till end" + " i: " + i);
            }
            if(i < k) {
                return result;
            }
            ListNode processing = prevHead;
            ListNode prev = nextHead;
            while(processing != nextHead) {
                ListNode next = processing.next;
                processing.next = prev;
                prev = processing;
                processing = next;
            }
            if(result == null) {
                result = prev;
            }
            if(prevEnd != null) {
                prevEnd.next = prev;
            }
            prevEnd = prevHead;
            prevHead = nextHead;
        }
        return result;
    }
}
