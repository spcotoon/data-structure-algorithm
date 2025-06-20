package _01_data_structure._05_hash_table;

public class HashTableSample {

    private final int TABLE_SIZE = 10;

    private DoublyLinkedListSample<HashData>[] table;

    private static class HashData {

        private int key;
        private String value;

        public HashData(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    public HashTableSample() {

        this.table = (DoublyLinkedListSample<HashData>[]) new DoublyLinkedListSample[TABLE_SIZE];

        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] =  new DoublyLinkedListSample<>();
        }
    }

    private int hashFunction(int number) {
        return number % TABLE_SIZE;
    }

    public void set(int key, String value) {
        this.table[this.hashFunction(key)].insertAt(0, new HashData(key, value));
    }

    public String get(int key) {
        Node<HashData> currentNode = this.table[this.hashFunction(key)].getHead();

        while (currentNode != null) {
            if (currentNode.getData().getKey() == key) {
                return currentNode.getData().getValue();
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public void remove(int key) {
        DoublyLinkedListSample<HashData> list = this.table[this.hashFunction(key)];

        Node<HashData> currentNode = list.getHead();
        int deletedIndex = 0;

        while (currentNode != null) {
            if (currentNode.getData().getKey() == key) {
                list.deleteAt(deletedIndex);
            }
            currentNode = currentNode.getNext();
            deletedIndex++;
        }
    }
}
