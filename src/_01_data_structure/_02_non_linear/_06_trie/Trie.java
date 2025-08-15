package _01_data_structure._02_non_linear._06_trie;

import _01_data_structure._02_non_linear._05_heap.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = this.root;
        for (char ch : word.toCharArray()) {
            if (currentNode.getChildren().get(ch) != null) {
                currentNode = (TrieNode) currentNode.getChildren().get(ch);
            } else {
                TrieNode newNode = new TrieNode();

                currentNode.getChildren().put(ch, newNode);

                currentNode = newNode;
            }
        }

        currentNode.getChildren().put('*', 0);
    }

    public TrieNode search(String word, boolean isCounting) {
        TrieNode currentNode = this.root;

        for (char ch : word.toCharArray()) {
            if (currentNode.getChildren().get(ch) != null) {
                currentNode = (TrieNode) currentNode.getChildren().get(ch);
            } else {
                return null;
            }
        }

        if (isCounting) {
            Object countObj = currentNode.getChildren().get('*');

            if (countObj instanceof Integer) {
                currentNode.getChildren().put('*', ((Integer) countObj) + 1);
            }
        }
        return currentNode;
    }

    private void getAllWords(TrieNode node, String word, List<WordData> words) {
        for (Map.Entry<Character, Object> entry : node.getChildren().entrySet()) {
            char key = entry.getKey();
            Object value = entry.getValue();

            if (key == '*') {
                words.add(new WordData(word, (Integer) value));
            } else if (value instanceof TrieNode) {
                getAllWords((TrieNode) value, word + key, words);
            }
        }
    }

    public List<WordData> autoComplete(String prefix) {
        TrieNode node = search(prefix, false);
        if (node == null) return new ArrayList<>();

        List<WordData> words = new ArrayList<>();
        getAllWords(node, prefix, words);
        return words;
    }


    public List<WordData> autoCompleteByCount(String prefix) {
        List<WordData> words = autoComplete(prefix);
        if (words == null) return null;

        words.sort((a, b) -> Integer.compare(b.priority, a.priority)); // 내림차순
        return words;
    }
}
