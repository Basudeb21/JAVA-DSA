// package nil.CustomLinkedList;
class LinkedList<T> {
    // Instances Of LinkedList
    private Node head;
    public int size = 0;

    // Node of LinkedList
    private static class Node<T> {
        private T value;
        private Node next;

        public Node() {
            this.next = null;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void add(T value) {
        Node newNode = new Node(value, head);
        newNode.next = head;
        head = newNode;

        size++;
    }

    public void addTail(T value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;

    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public int find(T value) {
        Node current = head;
        int index = -1;
        int i = 0;
        while (current.next != null) {
            if (current.value == value) {
                index = i;
            }
            current = current.next;
            i++;
        }
        return index;
    }

    public T removeHead() throws IllegalStateException {
        if (head == null) {
            throw new IllegalStateException("EmptyListException");
        }

        T value = (T) head.value;
        head = head.next;
        size--;
        return value;
    }

    public boolean remove(T value) {
        Node temp = head;
        if (isEmpty()) {
            return false;
        } else if (value == head.value) {
            head = head.next;
            size--;
            return true;
        }
        while (temp.next != null) {
            System.out.println(temp + " " + temp.value);

            if (temp.next.value == value) {
                temp.next = temp.next.next;
                System.out.println("temp : " + temp);
                System.out.println();

                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Element : " + temp.value);
            temp = temp.next;
        }
    }

}

class MyLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println(list.isEmpty());
        list.add(1);
        list.add(2);
        list.add(10);
        list.add(23);
        list.add(11);
        System.out.println("Size : " + list.size);
        // list.print();
        // System.out.println(list.isEmpty());
        // System.out.println("Finding 5 "+list.find(5));
        // System.out.println("Finding 7 "+list.find(7));
        // System.out.println("Finding 10 "+list.find(10));
        // System.out.println(list.removeHead());
        list.print();
        System.out.println("After");

        list.remove(1);
        list.print();

    }
}
