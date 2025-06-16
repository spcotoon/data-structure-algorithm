package _01_data_structure._01_linked_list;

public class DoublyLinkedListSample {
    private Node head;
    private Node tail;
    private int count;

    public int getCount() {
        return count;
    }

    public Node getTail() {
        return this.tail;
    }

    public DoublyLinkedListSample() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public void insertAt(int index, int data) {
        if (index > this.count || index < 0) {
            throw new RuntimeException("범위를 넘어감.");
        }

        Node newNode = new Node(data);

        if (index == 0) {
            newNode.setNext(head);
            if (this.head != null) {
                this.head.setPrev(newNode);
            }
            this.head = newNode;
        } else if (index == this.count) {
            newNode.setNext(null);
            newNode.setPrev(this.tail);
            this.tail.setNext(newNode);
        } else {
            Node currentNode = this.head;

            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }

            newNode.setNext(currentNode.getNext());
            newNode.setPrev(currentNode);
            currentNode.setNext(newNode);
            newNode.getNext().setPrev(newNode);
        }

        if (newNode.getNext() == null) {
            this.tail = newNode;
        }
        this.count++;
    }

    public void printAll() {
        Node currentNode = this.head;
        StringBuilder text = new StringBuilder("[");

        while (currentNode != null) {
            text.append(currentNode.getData());
            currentNode = currentNode.getNext();

            if (currentNode != null) {
                text.append(", ");
            }
        }

        text.append("]");
        System.out.println(text);
    }

    public void clear() {
        this.head = null;
        this.count = 0;
    }

    public void insertLast(int data) {
        this.insertAt(this.count, data);
    }

    public Node deleteAt(int index) {
        if (index >= this.count || index < 0) {
            throw new RuntimeException("제거할수 없음.");
        }

        Node currentNode = this.head;

        if (index == 0) {
            Node deletedNode = this.head;

            if (this.head.getNext() == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.getNext();
                this.head.setPrev(null);
            }
            this.count--;
            return deletedNode;
        } else if (index == this.count - 1) {
            Node deletedNode = this.tail;
            this.tail.getPrev().setNext(null);
            this.tail = this.tail.getPrev();
            this.count--;
            return deletedNode;
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }

            Node deletedNode = currentNode.getNext();
            currentNode.setNext(currentNode.getNext().getNext());
            currentNode.getNext().setPrev(currentNode);
            this.count--;
            return deletedNode;
        }

    }

    public Node deleteLast() {
        return this.deleteAt(this.count - 1);
    }

    public Node getNodeAt(int index) {
        if (index > this.count || index < 0) {
            throw new RuntimeException("범위를 넘어감.");
        }

        Node currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }
}
