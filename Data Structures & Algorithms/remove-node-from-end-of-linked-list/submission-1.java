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
        ListNode dummy = new ListNode(-1);
        dummy.next = head; // critical step
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i < n; i++) {
            second = second.next;
        }

        while (second.next != null) {
            second = second.next;
            first = first.next;
        }

        // Need to remove the node after first
        first.next = first.next.next;

        return dummy.next;
    }
}
