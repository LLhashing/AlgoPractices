import java.util.LinkedList;

public class QueueBy2Stack {
    private LinkedList<Integer> in;
    private LinkedList<Integer> out;

    private QueueBy2Stack(){
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }

    public Integer poll(){
        move();
        return out.isEmpty() ? null : out.pollFirst();
    }

    public void offer(int value){
        in.offerFirst(value);
    }

    public Integer peek(){
        move();
        return out.isEmpty() ? null : out.peekFirst();
    }

    public int size(){
        return in.size()+out.size();
    }

    public boolean isEmpty(){
        return in.size()==0 && out.size()==0;
    }

    private void move(){
        if(!out.isEmpty()){
            return;
        }
        while(!in.isEmpty()){
            out.offerFirst(in.pollFirst());
        }

    }

}
