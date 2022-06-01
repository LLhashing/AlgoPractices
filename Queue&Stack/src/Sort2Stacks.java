//Given an array that is initially stored in one stack,
// sort it with one additional stacks (total 2 stacks).

import java.util.Deque;
import java.util.LinkedList;

public class Sort2Stacks {
    public void sort(LinkedList<Integer> s1) {
        if(s1 == null || s1.size() <= 1 ){
            return;
        }
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        sort(s1,s2);
    }

    //Method 1
    //buffer: top part is buffer, bottom part store sorted elements
    private void sort(Deque<Integer> input, Deque<Integer> buffer){
        while(!input.isEmpty()){
            int curMin = Integer.MAX_VALUE;
            int count = 0;
            while(!input.isEmpty()){
                int cur = input.pollFirst();
                if(cur < curMin){
                    curMin = cur;
                    count = 1;
                }else if (cur == curMin){
                    count ++;
                }
                buffer.offerFirst(cur);
            }
            while(!buffer.isEmpty() && buffer.peekFirst() >= curMin){
                int temp = buffer.pollFirst();
                if(temp != curMin){
                    input.offerFirst(temp);
                }
            }
            while(count -- >0){
                buffer.offerFirst(curMin);
            }
        }
        while(!buffer.isEmpty()){
            input.offerFirst(buffer.pollFirst());
        }
    }

    //Method 2
    //sort in descending order and store result in the bottom part of inout
    private void sort2(Deque<Integer> input, Deque<Integer> buffer){
        int prevMax = Integer.MAX_VALUE;
        while(input.peekFirst() < prevMax){
            int curMax = Integer.MAX_VALUE;
            int count = 0;
            while(!input.isEmpty() && input.peekFirst() < prevMax){
                int cur = input.pollFirst();
                if(cur > curMax){
                    curMax = cur;
                    count = 1;
                }else if (cur == curMax){
                    count ++;
                }
                buffer.offerFirst(cur);
            }
            while(count-- > 0){
                input.offerFirst(curMax);
            }
            while(!buffer.isEmpty()){
                int temp = buffer.pollFirst();
                if(temp != curMax){
                    input.offerFirst(temp);
                }
            }
            prevMax = curMax;
        }
    }
}
