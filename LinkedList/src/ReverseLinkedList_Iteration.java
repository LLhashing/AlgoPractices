//Reverse a singly-linked list iteratively.

/**
 * Implementation
 */
public class ReverseLinkedList_Iteration {
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while ( head != null) {
            ListNode next = head.next;
            next.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
