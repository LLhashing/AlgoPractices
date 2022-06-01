//Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null
// to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

/**
 * Solution
 */
public class ReOrderLinkedList {
    public ListNode reorder(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode right = reverse(middle.next);
        middle.next = null;
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while(head != null){
            curr.next = head;
            curr = curr.next;
            head = head.next;
            if(right != null){
                curr.next = right;
                curr = curr.next;
                right = right.next;
            }
        }
        return dummyHead.next;

    }
    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newhead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
}
