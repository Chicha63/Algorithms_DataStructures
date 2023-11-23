package DataStructures;

import Exceptions.RemoveFromEmptyException;

public class ArrayQueue<T> {
    private Object[] queue;
    private int head;
    private int tail;
    public ArrayQueue(int capacity){
        queue = new Object[capacity];
    }
    public ArrayQueue(Object[] queue) {
        this.queue = queue;
    }
    public ArrayQueue() {
        queue = new Object[5];
    }
    public void enqueue(T el){
        if (count() == queue.length-1){
            int countPR = count();
            Object[] arr = new Object[2*queue.length];

            System.arraycopy(queue, head, arr, 0, queue.length-head);
            System.arraycopy(queue, 0, arr, queue.length-head, tail);

            queue = arr;

            head = 0;
            tail = countPR;
        }
        queue[tail] = el;
        if (tail < queue.length-1){
            tail++;
        } else {
            tail = 0;
        }
    }

    public void dequeue(){
        if (isEmpty()){
            throw new RemoveFromEmptyException("Removing element from empty queue");
        }
        queue[head++] = null;
        if (isEmpty()){
            head = tail = 0;
        } else if (head == queue.length){
            head = 0;
        }
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        if (isEmpty()){
            throw new RemoveFromEmptyException("Peeking from empty queue");
        }
        return (T) queue[head];
    }

    private int count(){
        return head <= tail ? tail-head : tail - head + queue.length;
    }

    public boolean isEmpty(){
        return count() == 0;
    }
}
