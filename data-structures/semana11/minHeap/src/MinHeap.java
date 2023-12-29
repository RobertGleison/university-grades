import java.util.Comparator;

public class MinHeap<T> {
    private T[] data;
    private int size;
    private Comparator<T> comparator;


    @SuppressWarnings("unchecked")
    MinHeap(int capacity) {
        data = (T[]) new Object[capacity+1];
        size = 0;
        comparator = null;
    }


    MinHeap(int capacity, Comparator<T> comp) {
        this(capacity);
        comparator = comp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    // ---------------------------------------------------------------------

    public void insert(T value) {
        if (size + 1 >= data.length) throw new RuntimeException("Heap is full");
        size++;
        data[size] = value;
        upHeap(size);
    }

    public T min() {
        if (isEmpty()) return null;
        return data[1];
    }

    public T removeMin() {
        if (isEmpty()) return null;
        T min = data[1];
        data[1] = data[size];
        data[size] = null;
        size--;
        downHeap(1);
        return min;
    }

    // ---------------------------------------------------------------------

    private void upHeap(int i) {
        while (i>1 && smaller(i, i/2)) {
            swap(i, i/2);
            i = i/2;
        }
    }

    private void downHeap(int i) {
        while (2*i <= size) {
            int j = i*2;
            if (j<size && smaller(j+1, j)) j++;
            if (smaller(i, j)) break;
            swap(i, j);
            i = j;
        }
    }

    @SuppressWarnings("unchecked") // Para que o java não se queixe do cast que diz que elementos são comparaveis
    private boolean smaller(int i, int j) {
        if (comparator == null) // Se não existe comparador usar comparação natural
            return ((Comparable<? super T>) data[i]).compareTo(data[j]) < 0;
        else
            return comparator.compare(data[i], data[j]) < 0;
    }


    private void swap(int i, int j) {
        T tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

}