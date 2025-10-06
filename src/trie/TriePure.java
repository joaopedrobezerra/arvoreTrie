
package trie;

public class TriePure {
    private final TrieNode root;

    public TriePure() {
        root = new TrieNode();
    }

    private int charToIndex(char c) {
        return c - 'a';
    }

    public void insert(String word) {
        if (word == null) return;
        TrieNode node = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            int idx = charToIndex(c);
            if (idx < 0 || idx >= 26) {
                return;
            }
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        if (word == null) return false;
        TrieNode node = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            int idx = charToIndex(c);
            if (idx < 0 || idx >= 26) return false;
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.isEndOfWord;
    }

    
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        TrieNode node = root;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            char c = prefix.charAt(i);
            int idx = charToIndex(c);
            if (idx < 0 || idx >= 26) return false;
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return true;
    }

    public boolean remove(String word) {
        if (word == null) return false;
        return removeHelper(root, word, 0);
    }

    private boolean removeHelper(TrieNode node, String word, int index) {
        if (node == null) return false;
        
        if (index == word.length()) {
            if (!node.isEndOfWord) return false;
            node.isEndOfWord = false;
            return hasNoChildren(node);
        }
        
        char c = word.charAt(index);
        int idx = charToIndex(c);
        if (idx < 0 || idx >= 26) return false;
        
        TrieNode child = node.children[idx];
        if (child == null) return false;
        
        boolean shouldDeleteChild = removeHelper(child, word, index + 1);
        
        if (shouldDeleteChild) {
            node.children[idx] = null;
            return !node.isEndOfWord && hasNoChildren(node);
        }
        
        return false;
    }

    private boolean hasNoChildren(TrieNode node) {
        if (node == null) return true;
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    public String[] suggestions(String prefix, int max) {
        if (prefix == null || max <= 0) return new String[0];
        TrieNode node = root;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            char c = prefix.charAt(i);
            int idx = charToIndex(c);
            if (idx < 0 || idx >= 26) return new String[0];
            if (node.children[idx] == null) return new String[0];
            node = node.children[idx];
        }

        SimpleStringList list = new SimpleStringList(8);
        char[] buffer = new char[1000];
        for (int i = 0; i < len && i < buffer.length; i++) buffer[i] = prefix.charAt(i);

        collect(node, buffer, len, list, max);
        return list.toArray();
    }

    
    private void collect(TrieNode node, char[] buffer, int depth, SimpleStringList list, int max) {
        if (node == null) return;
        if (list.size() >= max) return;

        if (node.isEndOfWord) {
            String s = new String(buffer, 0, depth);
            list.add(s);
            if (list.size() >= max) return;
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                if (depth < buffer.length) {
                    buffer[depth] = (char) ('a' + i);
                    collect(node.children[i], buffer, depth + 1, list, max);
                    if (list.size() >= max) return;
                } else {
                    return;
                }
            }
        }
    }
}
