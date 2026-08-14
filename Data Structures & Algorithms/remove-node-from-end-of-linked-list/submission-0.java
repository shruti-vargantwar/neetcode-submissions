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
        dummy.next = head;
        ListNode first = dummy, second = dummy;

        // Move second pointer n spaces ahead
        for (int i = 0; i < n; i++) {
            second = second.next;
        }

        // Move both now, until the next of second pointer is null
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        // We now have to remove the node next of first pointer
        first.next = first.next.next;

        return dummy.next;
    }
}
