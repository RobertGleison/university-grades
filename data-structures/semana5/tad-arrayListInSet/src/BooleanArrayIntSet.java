//The implementation only works when it is known that x falls within the range of 1 to n.

public class BooleanArrayIntSet implements IntSet {
    private boolean[] isElement;
    private int size;

    public BooleanArrayIntSet(int n) {
        this.isElement = new boolean[n];
        this.size = 0;
    }

    @Override
    public boolean contains(int x) {
        return isElement[x-1];
    }

    @Override
    public boolean add(int x) {
        if (!contains(x)) {
            isElement[x-1] = true;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int x) {
        if (contains(x)) {
            isElement[x-1] = false;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        isElement = new boolean[isElement.length];
        size = 0;
    }

    @Override
    public boolean equals(IntSet s) {
        if (size() != s.size()) return false;
        for (int i = 0; i < isElement.length; i++) {
            if (!s.contains(i) && contains(i))
                return false;
        }
        return true;
    }

    @Override
    public IntSet intersection(IntSet s) {
        IntSet intSet = new BooleanArrayIntSet(isElement.length);
        for (int i = 0; i < isElement.length; i++) {
            if (s.contains(i) && contains(i))
                intSet.add(i);
        }
        return intSet;
    }
}
