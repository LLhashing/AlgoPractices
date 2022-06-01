public class MergeSort {
    public ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(middleNext);
        ListNode newHead = merge(left, right);
        return newHead;
    }
    private ListNode merge(ListNode one, ListNode two ){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(one != null && two != null){
            if(one.value <= two.value){
                cur.next = one;
                one = one.next;
            }else{
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }
        if(one != null){
            cur.next = one;
        }
        if(two != null){
            cur.next = two;
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
}
