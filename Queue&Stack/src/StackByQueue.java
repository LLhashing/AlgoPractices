import java.util.ArrayDeque;
import java.util.Queue;

public class StackByQueue {

    private Queue<Integer> q;

    public StackByQueue(){
        q = new ArrayDeque<>();
    }

    public Integer pop(){
        if(q.isEmpty()){
            return null;
        }
        int size = q.size();
        while(--size != 0){
            q.offer(q.poll());
        }
        return q.poll();
    }

    public Integer top(){
        if(q.isEmpty()){
            return null;
        }
        int ret = pop();
        q.offer(ret);
        return ret;
    }

    public void push(int value){
        q.offer(value);
    }

    public int size(){
        return q.size();
    }

    public boolean isEmpty(){
        return q.isEmpty();
    }
}
