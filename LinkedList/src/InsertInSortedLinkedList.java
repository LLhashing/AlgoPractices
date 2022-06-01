public class InsertInSortedLinkedList {
    public ListNode insert(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if(head == null || head.value > value){
            newNode.next = head;
            return newNode;
        }
        ListNode dummyHead = head;
        while(head.next != null && head.next.value < value){
            head = head.next;
        }
        ListNode temp = head.next;
        head.next = newNode;
        newNode.next = temp;
        return dummyHead;
    }
}
