package _01_data_structure._01_linear._05_hash_table;

public class HashTablePractice {
    public static void main(String[] args) {

        HashTableSample hashTable = new HashTableSample();

        hashTable.set(1, "AAA");
        hashTable.set(11, "BBB");
        hashTable.set(21, "CCC");
        hashTable.set(2, "DDD");
        hashTable.set(3, "EEE");
        hashTable.set(4, "FFF");
        hashTable.set(5, "GGG");
        hashTable.set(15, "HHH");
        hashTable.set(25, "III");
        hashTable.set(6, "JJJ");
        hashTable.set(16, "KKK");

        System.out.println("|1|'AAA','BBB','CCC'|");

        System.out.println("1: " + hashTable.get(1));
        hashTable.remove(1);
        System.out.println("after remove(1): " + hashTable.get(1));
        System.out.println("11: " + hashTable.get(11));
        System.out.println("21: " + hashTable.get(21));
    }
}
