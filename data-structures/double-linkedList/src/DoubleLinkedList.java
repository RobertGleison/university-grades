public class DoubleLinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public DoubleLinkedList(Node<T> first, Node<T> last, int size) {
        this.first = new Node<T>(null, null, null);
        this.last = new Node<T>(null, null, first);
        first.setNext(last);
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size==0);
    }

    public T getFirst(){
        if(isEmpty()) return null;
        return first.getNext().getValue();
    }

    public T getLast(){
        if(isEmpty()) return null;
        return last.getPrevious().getValue();
    }

    public void addBetween(Node<T> a, Node<T> b, T value){
        Node<T> newNode = new Node<>(value, a, b);
        a.setNext(newNode);
        b.setPrevious(newNode);
        size++;
    }

   public void removeLast(){
        if(isEmpty()) return;
        remove(last.getPrevious());
           }

   public void removeFirst(){
        if(isEmpty()) return;
        remove(first.getNext());
   }

   public void remove(Node<T> n){
        Node<T> next = n.getNext();
        Node<T> prev = n.getPrevious();
        next.setPrevious(prev);
        prev.setNext(next);
        size--;
   }



}
