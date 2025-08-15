package _01_data_structure._02_non_linear._06_trie;

public class TriePractice {
    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("고등어");
        trie.insert("김치");
        trie.insert("김치찜");
        trie.insert("김치찌개");

        trie.search("김치찌개", true);
        trie.search("김치찌개", true);
        trie.search("김치", true);
        trie.search("김치", true);
        trie.search("김치", true);
        trie.search("김치", true);
        trie.search("김치찜", true);

        System.out.println(trie.autoCompleteByCount("김치"));
    }
}
