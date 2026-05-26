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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode workingNode = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if(l1 != null) {
                val1 = l1.val;
                l1 = l1.next;            
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int val = val1 + val2 + carry;
            if (val >= 10) {
                carry = val / 10;
                val = val % 10;
            } else {
                carry = 0;
            }
            workingNode.next = new ListNode(val);
            workingNode = workingNode.next;
        }
        if(carry > 0) {
            workingNode.next = new ListNode(carry);
        }
        return result.next;
    }
}
