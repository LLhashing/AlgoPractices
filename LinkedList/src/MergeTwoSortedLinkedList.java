public class MergeTwoSortedLinkedList {
    public ListNode merge(ListNode one, ListNode two) {
        if(one == null){
            return two;
        }
        if(two == null){
            return one;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while( one != null && two != null){
            if(one.value <= two.value){
                cur.next = one;
                one = one.next;
                cur = cur.next;
            }else{
                cur.next = two;
                two = two.next;
                cur = cur.next;
            }
        }
        if(one != null){
            cur.next = one;
        }
        if(two != null){
            cur.next = two;
        }
        return dummyHead.next;
    }
}
