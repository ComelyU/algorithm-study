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
public class LTC25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        // Initialize dummy node
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {
            // Find the kth node from the current group
            ListNode kthNode = getKthNode(groupPrev, k);

            if (kthNode == null) { // Not enough nodes left to form a group of size k
                break;
            }

            ListNode groupNext = kthNode.next;

            // Reverse the current group of k nodes
            ListNode prev = kthNode.next;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Reconnect the reversed group back into the main list
            ListNode temp = groupPrev.next; // the original head becomes the new tail
            groupPrev.next = kthNode; // previous group points to the new head;
            groupPrev = temp; // move groupPrev to the end of the reversed group(segment)
        }

        return dummy.next;
    }

    // find the k-th node from a given starting point
    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }

        return node;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}


