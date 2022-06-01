public class RemoveElement {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null || (head.next == null && head.value == val)){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(head != null){
            if(head.value != val){
                cur.next = new ListNode(head.value);
                cur = cur.next;
            }
            head = head.next;
        }
        return dummyHead.next;
    }
}
