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
public class LTC24 {

    public ListNode swapPairs(ListNode head) { // Iterative
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
        }

        return dummy.next;
    }

//    public ListNode swapPairs(ListNode head) { // Recursive
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode first = head;
//        ListNode second = head.next;
//
//        first.next = swapPairs(second.next);
//        second.next = first;
//
//        return second;
//    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
