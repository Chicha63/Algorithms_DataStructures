package DataStructures;

public class SymbolTableBS<TKey, TValue> {
    private TKey[] keys;
    private TValue[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public SymbolTableBS(int size) {
        keys = (TKey[]) new Object[size];
        values = (TValue[]) new Object[size];
        this.size = size;
    }

    public int rank(TKey key){
        return 0;
    }

    public TValue get(TKey key){
        return null;
    }

    public void add(TKey key, TValue value){

    }

    public void remove(TKey key){

    }

    public TKey[] getKeys() {
        return keys;
    }

    public int getSize() {
        return size;
    }
}
