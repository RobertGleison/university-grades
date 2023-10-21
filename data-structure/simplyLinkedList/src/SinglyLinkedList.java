public class SinglyLinkedList<T> {
    private Node<T> first;
    private int size;

    public SinglyLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value, first);
        first = newNode;
        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<T>(value, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(newNode);
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
            // Ciclo com for e uso de de size para mostrar alternativa ao while
            Node<T> cur = first;
            for (int i=0; i<size-2; i++)
                cur = cur.getNext();
            cur.setNext(cur.getNext().getNext());
        }
        size--;
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

