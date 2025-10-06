package trie;

public class SimpleStringList {
    private String[] data;
    private int size;
    private int capacity;

    public SimpleStringList(int initialCapacity) {
        if (initialCapacity <= 0) initialCapacity = 4;
        data = new String[initialCapacity];
        size = 0;
        capacity = initialCapacity;
    }

    public void add(String s) {
        if (size == capacity) {
    String[] novo = new String[capacity * 2];
    for (int i = 0; i < capacity; i++) {
        novo[i] = data[i];
    }
    data = novo;
    capacity = capacity * 2;
}
        data[size++] = s;
    }

    public String[] toArray() {
        String[] out = new String[size];
        System.arraycopy(data, 0, out, 0, size);
        return out;
    }

    public int size() {
        return size;
    }
}
