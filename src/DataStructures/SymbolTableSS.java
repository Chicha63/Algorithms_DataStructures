package DataStructures;

public class SymbolTableSS<TKey, TValue> {
    private class Node{
        public TKey key;
        public TValue value;

        public Node next;

        public Node(TKey key, TValue value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private Node first;
    private int count = 0;

    public TValue get(TKey key){
        for (Node x = first; x != null; x = x.next){
            if (key.equals(x.key)){
                return x.value;
            }
        }
        return null;
    }

    public void add(TKey key, TValue value){
        if (key == null)
            throw new IllegalArgumentException("No nulls allowed in key");
        for (Node x = first; x != null; x = x.next){
            if (key.equals(x.key)){
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);

        count++;
    }

    public boolean contains(TKey key){
        for (Node x = first; x != null; x = x.next){
            if (key.equals(x.key))
                return true;
        }
        return false;
    }

    public TKey[] keys(){
        ArrayStack<TKey> arrayStack = new ArrayStack<>();
        for (Node x = first; x != null; x = x.next){
            arrayStack.push(x.key);
        }
        return arrayStack.toArray();
    }

    public void remove(TKey key){
        if (key == null)
            throw new IllegalArgumentException("No nulls allowed in key");
        if (first.key.equals(key)){
            first = null;
            return;
        }
        for (Node x = first; x != null; x = x.next){
            if (x.next.key.equals(key)){
                x.next = x.next.next;
                return;
            }
        }
    }

    public int getCount() {
        return count;
    }
}
