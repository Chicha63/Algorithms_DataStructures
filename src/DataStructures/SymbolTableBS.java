package DataStructures;

import java.util.Comparator;

public class SymbolTableBS<TKey, TValue> {
    private TKey[] keys;
    private TValue[] values;
    private int count = 0;
    private int size;
    private Comparator<TKey> comparator;

    @SuppressWarnings("unchecked")
    public SymbolTableBS(int size, Comparator<TKey> comparator) {
        keys = (TKey[]) new Object[size];
        values = (TValue[]) new Object[size];
        this.size = size;
        this.comparator = comparator;
    }

    @SuppressWarnings("unchecked")
    public SymbolTableBS() {
        keys = (TKey[]) new Object[5];
        values = (TValue[]) new Object[5];
        this.size = 5;
    }

    public int rank(TKey key){
        int bot = 0;
        int top = count-1;

        while (bot <= top){
            int mid = bot + (top - bot) / 2;
            int cmp = comparator.compare(key,keys[mid]);
            if (cmp < 0)
                top = mid - 1;
            else if (cmp > 0)
                bot = mid+1;
            else
                return mid;
        }
        return bot;
    }

    public TValue get(TKey key){
        if(isEmpty())
            return null;
        int rank = rank(key);
        if (rank < count && comparator.compare(keys[rank], key) == 0){
            return values[rank];
        }
        return null;
    }

    public void add(TKey key, TValue value){
        if (key == null)
            throw new IllegalArgumentException("Key can not be null");

        int rank = rank(key);

        if (rank < count && comparator.compare(keys[rank], key) == 0){
            values[rank] = value;
            return;
        }
        if (count == size)
            resize(count*2);

        for (int i = count; i > rank; i--){
            keys[i] = keys[i-1];
            values[i] = values[i-1];
        }
        keys[rank] = key;
        values[rank] = value;
        count++;
    }


    public void remove(TKey key){
        if (key == null)
            throw new IllegalArgumentException("Key cannot be null");
        if (isEmpty())
            return;
        int rank = rank(key);
        if (rank == count || comparator.compare(keys[rank], key)!= 0)
            return;
        for (int i = rank; i < count-1; i++){
            keys[i] = keys[i+1];
            values[i] = values[i+1];
        }
        count--;
        keys[count] = null;
        values[count] = null;
    }

    public void trimToCount(){
        resize(count);
    }

    public boolean contains(TKey key){
        int rank = rank(key);
        return rank < count && comparator.compare(keys[rank], key) == 0;
    }

    public TKey[] getKeys() {
        return keys;
    }
     
    @SuppressWarnings("unchecked")
    private void resize(int size) {
        TKey[] tempK = (TKey[]) new Object[size];
        TValue[] tempV = (TValue[]) new Object[size];
        this.size = size;

        for (int i = 0; i < count; i++){
            tempK[i] = keys[i];
            tempV[i] = values[i];
        }

        values = tempV;
        keys = tempK;
    }

    private boolean isEmpty() {
        return count == 0;
    }

    public int getSize() {
        return size;
    }

    public int getCount(){
        return count;
    }
}
