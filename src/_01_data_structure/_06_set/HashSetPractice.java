package _01_data_structure._06_set;

public class HashSetPractice {
    public static void main(String[] args) {
        HashSetSample hashSet = new HashSetSample();

        System.out.println("isEmpty(): " + hashSet.isEmpty());
        System.out.println("===데이터 삽입===");
        hashSet.add(1);
        hashSet.add(1);
        hashSet.add(123);
        hashSet.add(512);
        hashSet.printAll();
        System.out.println("isEmpty(): " + hashSet.isEmpty());

        System.out.println("===데이터 체크1===");
        System.out.println("isContain: " + hashSet.isContain(1));

        System.out.println("===데이터1 제거===");
        hashSet.remove(1);
        hashSet.printAll();
        System.out.println("isEmpty: " + hashSet.isEmpty());

        System.out.println("===데이터 체크2===");
        System.out.println("isContain: " + hashSet.isContain(1));

        System.out.println("===clear===");
        hashSet.clear();
        hashSet.printAll();
        System.out.println("isEmpty: " + hashSet.isEmpty());
    }
}
