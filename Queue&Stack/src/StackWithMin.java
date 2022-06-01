import java.util.Deque;
import java.util.LinkedList;

/**
 * Support min() operation
 */
public class StackWithMin {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public StackWithMin(){
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public int min(){
        if(minStack.isEmpty()){
            return -1;
        }
        return minStack.peekFirst();
    }

    public void push(int value){
        stack.offerFirst(value);
        if(minStack.isEmpty() || value <= minStack.peekFirst()){
            minStack.offerFirst(value);
        }
    }

    public int pop(){
        if(stack.isEmpty()){
            return -1;
        }
        Integer result = stack.pollFirst();
        if( minStack.peekFirst().equals(result) ){
            minStack.pollFirst();
            if(minStack.isEmpty()){
                findMin();
            }
        }
        return result;
    }

    private void findMin(){
        if(stack.isEmpty()){
            return;
        }
        LinkedList<Integer> buffer = new LinkedList<>();
        int curMin = Integer.MAX_VALUE;
        int count = 0;
        while(!stack.isEmpty()){
            int temp = stack.pollFirst();
            buffer.offerFirst(temp);
            if(temp < curMin){
                curMin = temp;
                count = 1;
            }else if(temp == curMin){
                count ++;
            }
        }
        while(count > 0){
            minStack.offerFirst(curMin);
            count --;
        }
        while(!buffer.isEmpty()){
            stack.offerFirst(buffer.pollFirst());
        }
    }



}
