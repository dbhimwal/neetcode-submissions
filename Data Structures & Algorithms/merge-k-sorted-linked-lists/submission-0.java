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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode result = new ListNode();
        ListNode resultEnd = result;

        for(ListNode node : lists) {
            minHeap.add(node);
        }

        while(!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            resultEnd.next = smallest;
            if(smallest.next != null) {
                minHeap.add(smallest.next);
            }
            resultEnd = resultEnd.next;
        }
        return result.next;
    }
}
