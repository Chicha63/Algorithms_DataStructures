package DataStructures;

import Exceptions.RemoveFromEmptyException;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    private int size = 0;


    public void addFirst(T value){
        addFirst(new Node<T>(value));
    }

    private void addFirst(Node<T> node){
        Node<T> temp = head;
        setHead(node);
        head.setNext(temp);

        size++;

        if (size == 1){
            tail = head;
        }
    }

    public void addLast(T value){
        addLast(new Node<T>(value));
    }

    private void addLast(Node<T> node) {
        if (size == 0){
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new RemoveFromEmptyException("Linked list is empty");

        head = head.getNext();
        size--;
        if (isEmpty()){
            tail = null;
        }
    }

    public void removeLast() {
        if (isEmpty())
            throw new RemoveFromEmptyException("Linked list is empty");
        size--;
        if (isEmpty())
            head = tail = null;
        else {
            Node<T> current = head;
            while (current.getNext() != tail){
                current = current.getNext();
            }
            current.setNext(null);
            tail = current;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> current = head;
        while (current != null){
            stringBuilder.append(current.getValue()).append(" ");
            current = current.getNext();
        }
        return stringBuilder.toString();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Node<T> getHead() {
        return head;
    }

    private void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    private void setTail(Node<T> tail) {
        this.tail = tail;
    }
}
