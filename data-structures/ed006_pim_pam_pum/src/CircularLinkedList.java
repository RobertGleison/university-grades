public class CircularLinkedList<T> {
    private Node<T> last;
    private int size;

    public CircularLinkedList() {
        this.size = 0;
        this.last = null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void addFirst(T value){
        if(isEmpty()){
            last = new Node<T> (value, null);
            last.setNext(last);
        }
        else{
            Node<T> newNode = new Node<T>(value, last.getNext());
            last.setNext(newNode);
        }
        size++;
    }

    public void addLast(T value) {
        if (isEmpty()) {
            last = new Node<T>(value, null);
            last.setNext(last);
        }
        else{
            Node<T> newNode = new Node<T> (value, last.getNext());
            last.setNext(newNode);
        }
        size++;
    }

    public void removeFirst(){
        if(isEmpty()) return;
        if(size == 1) last = null;
        else{
            last.setNext(last.getNext().getNext());
            size--;
        }
    }

    public void removeLast(){
        if(isEmpty()) return;
        if(size == 1) last = null;
        else{
            Node<T> curr = last.getNext();
            while(curr.getNext()!= last) curr = curr.getNext();
            curr.setNext(curr.getNext().getNext());
            last = curr;
            size--;
        }
    }

    public T getFirst(){
        if (isEmpty()) return null;
        return last.getNext().getValue();
    }

    public T getLast(){
        if(isEmpty()) return null;
        return last.getValue();
    }

    public void rotate(){
        if(!isEmpty()) last = last.getNext();
    }
}
