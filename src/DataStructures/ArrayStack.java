package DataStructures;

import Exceptions.RemoveFromEmptyException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayStack<T> {
    private Object[] items;
    private int size;

    public ArrayStack(T[] items) {
        this.items = items;
    }
    public ArrayStack() {
        items = new Object[5];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        return (T)items[size-1];
    }

    @SuppressWarnings("unchecked")
    public T pop(){
        if (isEmpty())
            throw new RemoveFromEmptyException("Popping from empty stack");
        T toReturn = (T)items[--size];
        Object[] temp = new Object[items.length];
        System.arraycopy(items,0,temp,0,size);
        items = temp;
        return toReturn;
    }

    public void push(T toPush){
        if (items.length == size){
            Object[] extended = new Object[size * 2];
            System.arraycopy(items, 0, extended, 0, size);
            items = extended;
        }
        items[size++] = toPush;
    }

    public void trim(){
        Object[] temp = new Object[size];
        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(){
        return (T[]) items;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
