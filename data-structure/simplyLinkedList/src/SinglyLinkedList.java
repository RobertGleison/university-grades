public class SinglyLinkedList<T> {
    private Node<T> first;
    private int size;

    public SinglyLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void addFirst(T value) {
        first = new Node<>(value, first);
        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<T>(value, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> curr = first;
            while (curr.getNext() != null) curr = curr.getNext();
            curr.setNext(newNode);
        }
        size++;
    }

    public T getFirst() {
        if (isEmpty()) return null;
        return first.getValue();
    }

    public T getLast() {
        if (isEmpty()) return null;
        Node<T> curr = first;
        while (curr.getNext() != null) curr = curr.getNext();
        return curr.getValue();
    }

    public void removeFirst() {
        if (isEmpty()) return;
        first = first.getNext();
        size--;
    }

    public void removeLast() {
        if (isEmpty()) return;
        if (size == 1) {
            first = null;
        } else {
            Node<T> curr = first;
            for (int i = 0; i < size - 2; i++)
                curr = curr.getNext();
            curr.setNext(curr.getNext().getNext());
        }
        size--;
    }

    public T remove(int pos) {
        if ((size - 1) < pos || pos < 0) return null;
        Node<T> curr = first;
        if (pos == 0) {
            first = first.getNext();
            size--;
            return curr.getValue();
        }
        for (int i = 0; i < pos - 1; i++) {
            curr = curr.getNext();
        }
        T value = curr.getNext().getValue();
        curr.setNext(curr.getNext().getNext());
        size--;
        return value;
    }

    public T get(int pos) {
        if ((size - 1) < pos || pos < 0) return null;
        Node<T> curr = first;
        for (int i = 0; i < pos; i++) {
            curr = curr.getNext();
        }
        return curr.getValue();
    }

    public int count(T value) {
        Node<T> curr = first;
        int count = 0;
        if (curr.getValue().equals(value)) count++;
        while (curr.getNext() != null) {
            curr = curr.getNext();
            if (curr.getValue().equals(value)) count++;
        }
        return count;
    }

    public void duplicate() {
        if (isEmpty()) return;
        Node<T> curr = first;
        int initialSize = this.size;
        for (int i = 0; i < initialSize; i++) {
            Node<T> newNode = new Node<T>(curr.getValue(), null);
            newNode.setNext(curr.getNext());
            curr.setNext(newNode);
            curr = curr.getNext().getNext();
            this.size++;
        }
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<T>();
        Node<T> curr = first;
        for (int i = 0; i < size; i++) {
            newList.addLast(curr.getValue());
            curr = curr.getNext();
        }
        return newList;
    }

    public void removeAll(T value) {
        if (isEmpty())  return;
        while (first != null && first.getValue().equals(value)) {
            first = first.getNext();
            size--;
        }
        Node<T> curr = first;

        while (curr != null && curr.getNext() != null) {
            if (curr.getNext().getValue().equals(value)) {
                curr.setNext(curr.getNext().getNext());
                size--;
            } else {
                curr = curr.getNext();
            }
        }
    }

    @Override
    public String toString() {
        String str = "{";
        Node<T> curr = first;
        while (curr != null) {
            str += curr.getValue();
            curr = curr.getNext();
            if (curr != null) str += ",";
        }
        str += "}";
        return str;
    }
}

