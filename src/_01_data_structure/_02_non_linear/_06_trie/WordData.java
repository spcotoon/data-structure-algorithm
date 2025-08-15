package _01_data_structure._02_non_linear._06_trie;

public class WordData {
    String word;
    int count;
    int priority;

    public WordData(String word, int count) {
        this.word = word;
        this.count = count;
        this.priority = count;
    }

    @Override
    public String toString() {
        return word + " (" + count + ")";
    }
}
