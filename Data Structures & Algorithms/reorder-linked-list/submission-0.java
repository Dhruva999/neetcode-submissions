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

        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

    

        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head;
        ListNode sec = slow.next;

        slow.next = null;

        ListNode prev = null;
        ListNode curr = sec;

        while(curr!=null){

            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        sec = prev;

        while(sec!=null){

            ListNode tmp = first.next;
            first.next = sec;
            sec = sec.next;
            first.next.next = tmp;
            first = tmp;
        }
        
    }
}
