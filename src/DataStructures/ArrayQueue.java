package DataStructures;

public class ArrayQueue<T> {
    private Object[] queue;
    private int head;
    private int tail;
    public ArrayQueue(Object[] queue) {
        this.queue = queue;
    }
    public ArrayQueue() {
        queue = new Object[5];
    }
    public void enqueue(T el){

    }



    public boolean isEmpty(){
        return head == tail;
    }
}
