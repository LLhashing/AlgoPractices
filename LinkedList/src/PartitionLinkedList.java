//Given a linked list and a target value T, partition it such that all nodes less than T
// are listed before the nodes larger than or equal to target value T.
// The original relative order of the nodes in each of the two partitions should be preserved.

/**
 * solution
 */
public class PartitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode curSmall = small;
        ListNode curLarge = large;
        while(head != null){
            if(head.value < target){
               curSmall.next = head;
               curSmall = curSmall.next;
            }else{
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        curSmall.next = large.next;
        return small.next;
    }
}
