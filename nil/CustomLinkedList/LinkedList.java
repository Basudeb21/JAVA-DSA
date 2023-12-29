class Node<T> {
    public T data;
    public Node<T> next;

    Node() {
        this.next = null;
    }

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListOperation<T> {
    Node<T> head;

    LinkedListOperation() {
        this.head = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;

    }

    public void add(T data, int index) {
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        if (index < 0) {
            throw new IndexOutOfBoundsException("Index location always positive.");
        }

        Node<T> current = head;
        int count = 0;
        while (count < index -1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Index Out Of Bound.");
        }
        newNode.next = current.next;
        current.next = newNode;

    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

}

class LinkedList {

    public static void main(String[] args) {
        LinkedListOperation<Integer> list = new LinkedListOperation<>();
        list.add(10);
        list.add(12);
        list.add(13);
        list.add(11);
        list.add(5, 3);
        list.addLast(300);

        list.display();

    }

}