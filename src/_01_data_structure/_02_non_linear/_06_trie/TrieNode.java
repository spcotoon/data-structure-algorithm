package _01_data_structure._02_non_linear._06_trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    private Map<Character, Object> children;


    public TrieNode() {
        this.children = new HashMap<>();
    }

    public Map<Character, Object> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "children=" + children +
                '}';
    }
}
