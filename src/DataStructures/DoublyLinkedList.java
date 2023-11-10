package DataStructures;

import Exceptions.RemoveFromEmptyException;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DoublyLinkedList<T> {
    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> tail;

    private int size = 0;

    public void addFirst(T value){
        addFirst(new DoublyLinkedNode<T>(value));
    }

    private void addFirst(DoublyLinkedNode<T> tDoublyLinkedNode) {
        DoublyLinkedNode<T> temp = head;
        head = tDoublyLinkedNode;
        head.setNext(temp);

        if (isEmpty()){
            tail = head;
        } else {
            temp.setPrevious(head);
        }
        size++;
    }

    public void addLast(T value){
        addLast(new DoublyLinkedNode<T>(value));
    }

    private void addLast(DoublyLinkedNode<T> tDoublyLinkedNode){
        if (isEmpty()){
            head = tDoublyLinkedNode;
        } else {
            tail.setNext(tDoublyLinkedNode);
            tDoublyLinkedNode.setPrevious(tail);
        }
        tail = tDoublyLinkedNode;
        size++;
    }

    public void removeFirst(){
        if (isEmpty())
            throw new RemoveFromEmptyException("Removing from empty list");
        head = head.getNext();
        size--;
        if (isEmpty()){
            tail = null;
        }else {
            head.setPrevious(null);
        }
    }

    public void removeLast(){
        if (isEmpty())
            throw new RemoveFromEmptyException("Removing from empty list");
        size--;
        if (isEmpty()){
            tail = null;
            head = null;
        }else {
            tail.getPrevious().setNext(null);
            tail = tail.getPrevious();
        }
    }

    public void removeAt(int index){
        if (index >= size)
            throw new IndexOutOfBoundsException("Index "+ index+" is bigger than size " + size);

        DoublyLinkedNode<T> current;

        if (size/2 > index){
            current = head;
            for (int i = 0; i < index; i++){
                current = current.getNext();
            }

            size--;

            if (isEmpty()){
                head = null;
                tail = null;
            }
            else if (index == 0){
                current.getNext().setPrevious(null);
                head = current.getNext();
            }else {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
            }
        } else {
            current = tail;
            for (int i = size-1; i > index; i--){
                current = current.getPrevious();
            }

            size--;

            if (isEmpty()){
                tail = null;
                head = null;
            }
            else if (index == size){
                current.getPrevious().setNext(null);
                tail = current.getPrevious();
            } else {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
            }
        }
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (DoublyLinkedNode<T> node = head; node != null; node = node.getNext()){
            arr[i++] = node.getValue();
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DoublyLinkedNode<T> current = head;
        while (current != null){
            stringBuilder.append(current.getValue()).append(" ");
            current = current.getNext();
        }
        return stringBuilder.toString();
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
