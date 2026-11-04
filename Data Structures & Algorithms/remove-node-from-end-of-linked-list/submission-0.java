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

        if (head ==null) return null;

        int len = 0;
        ListNode itr = head;

        while(itr!=null){
            len++;
            itr = itr.next;
        }

        if (n == len) {
            return head.next;
        }

        int idx = len - n-1;
        itr = head;

        while(idx > 0){
            itr = itr.next;
            idx--;
        }

        itr.next = itr.next.next;
        return head;
    }
}
