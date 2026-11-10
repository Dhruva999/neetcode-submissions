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
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            // Step 1: Find kth node
            ListNode kth = getKthNode(groupPrev, k);

            // If fewer than k nodes remain
            if (kth == null) {
                break;
            }

            // Step 2: Save next group's starting node
            ListNode groupNext = kth.next;

            // Step 3: Reverse current group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {

                ListNode next = curr.next;

                curr.next = prev;

                prev = curr;
                curr = next;
            }

            // Step 4: Connect reversed group
            ListNode temp = groupPrev.next;

            groupPrev.next = kth;

            groupPrev = temp;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {

        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
        
    }
}
