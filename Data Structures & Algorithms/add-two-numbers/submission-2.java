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
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }

            // Decide fate of carry and sum
            if (sum > 9) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }

            // Create a linked list of answer
            ListNode answer = new ListNode(sum);
            head.next = answer;
            head = head.next;
        }

        // Sum of last didgits can result in carry
        if (carry > 0) {
            ListNode answer = new ListNode(carry);
            head.next = answer;
        }

        return dummy.next;
    }
}
