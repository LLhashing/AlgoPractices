public class CheckIfPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;
        ListNode right = reverse(middleNext);
        while(head != null && right != null){
            if(head.value != right.value){
                return false;
            }
            head = head.next;
            right = right.next;
        }
        return true;
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
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
