/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a copy of each node
        // and insert it immediately after the original node.
        Node curr = head;

        while (curr != null) {
            Node copy = new Node(curr.val);

            copy.next = curr.next;
            curr.next = copy;

            curr = copy.next;
        }

        // Step 2: Assign random pointers to copied nodes.
        curr = head;

        while (curr != null) {
            Node copy = curr.next;

            if (curr.random != null) {
                copy.random = curr.random.next;
            }

            curr = copy.next;
        }

        // Step 3: Separate original and copied linked lists.
        Node dummy = new Node(0);
        Node copyTail = dummy;

        curr = head;

        while (curr != null) {
            Node copy = curr.next;

            // Restore original list.
            curr.next = copy.next;

            // Connect copied list.
            copyTail.next = copy;
            copyTail = copy;

            curr = curr.next;
        }

        return dummy.next;
        
    }
}
