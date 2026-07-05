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
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        ListNode mid = head;
        while(temp != null && temp.next != null) {
            mid = mid.next;
            temp = temp.next.next;
        }
        ListNode tail = reverse(mid);
        temp = head;
        ListNode end = tail;
        while((temp != null) && (end != null)) {
            if(temp.val != end.val) {
                return false;
            }
            temp = temp.next;
            end = end.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode current = node;
        ListNode prev = null;
        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;  
        }
        return prev;
    }
}