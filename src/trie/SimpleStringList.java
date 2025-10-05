package trie;

public class SimpleStringList {
    private String[] data;
    private int size;

    public SimpleStringList(int initialCapacity) {
        if (initialCapacity <= 0) initialCapacity = 4;
        data = new String[initialCapacity];
        size = 0;
    }

    public void add(String s) {
        if (size == data.length) {
            String[] novo = new String[data.length * 2];
            System.arraycopy(data, 0, novo, 0, data.length);
            data = novo;
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
