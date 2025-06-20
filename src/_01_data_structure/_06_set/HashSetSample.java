package _01_data_structure._06_set;

import _01_data_structure._05_hash_table.DoublyLinkedListSample;
import _01_data_structure._05_hash_table.HashTableSample;
import _01_data_structure._05_hash_table.Node;

public class HashSetSample {

    private HashTableSample hashTable;

    public HashSetSample() {
        this.hashTable = new HashTableSample();
    }

    public void add(int data) {
        if (this.hashTable.get(data) == null) {
            this.hashTable.set(data, "-1");
        }
    }

    public boolean isContain(int data) {
        return this.hashTable.get(data) != null;
    }

    public void remove(int data) {
        this.hashTable.remove(data);
    }

    public void clear() {
        DoublyLinkedListSample[] table = this.hashTable.getTable();
        for (int i = 0; i < table.length; i++) {
            table[i].clear();
        }
    }

    public boolean isEmpty() {
        boolean empty = true;
        DoublyLinkedListSample[] table = this.hashTable.getTable();
        for (int i = 0; i < table.length; i++) {
            if (table[i].getCount() > 0) {
                empty = false;
                break;
            }
        }

        return empty;
    }

    public void printAll() {
        DoublyLinkedListSample[] table = this.hashTable.getTable();
        for (int i = 0; i < table.length; i++) {
            Node currentNode = table[i].getHead();
            while (currentNode != null) {
                System.out.println(currentNode.getData());
                currentNode = currentNode.getNext();
            }
        }
    }
}
