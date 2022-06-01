public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int addition = 0;
        while(l1 != null || l2 != null || addition != 0){
            if(l1 != null){
                addition += l1.value;
                l1 = l1.next;
            }
           if(l2 != null){
               addition += l2.value;
               l2 = l2.next;
           }
            cur.next = new ListNode(addition%10);
            addition = addition/10;
            cur = cur.next;
        }
        return dummyHead.next;
    }

}
