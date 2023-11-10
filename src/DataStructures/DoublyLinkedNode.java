package DataStructures;

public class DoublyLinkedNode<T>{
    private DoublyLinkedNode<T> previous;
    private DoublyLinkedNode<T> next;
    private T value;
    public DoublyLinkedNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoublyLinkedNode<T> getNext(){
        return next;
    }

    public DoublyLinkedNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedNode<T> previous) {
        this.previous = previous;
    }

    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }

}
