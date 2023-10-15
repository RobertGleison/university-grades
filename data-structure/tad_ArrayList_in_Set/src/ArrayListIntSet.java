public class ArrayListIntSet implements IntSet {
    private int size;
    private int elem[];

    ArrayListIntSet(int maxSize) {
        elem = new int[maxSize];
        size = 0;
    }

    public boolean contains(int x) {
        for (int i = 0; i < size; i++)
            if (elem[i] == x)
                return true;
        return false;
    }

    public boolean add(int x) {
        if (contains(x)) return false;
        else {
            if (size == elem.length) {
                int new_array[] = new int[size * 2];
                for (int i = 0; i < size; i++)
                    new_array[i] = elem[i];
                elem = new_array;
            }
            elem[size] = x;
            size++;
            return true;
        }
    }

    public boolean remove(int x) {
        if (!contains(x)) return false;
        else {
            int pos = 0;
            while (elem[pos] != x) pos++;
            size--;
            elem[pos] = elem[size];
            return true;
        }
    }


    public void clear() {
        size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String res = "{";
        for (int i = 0; i < size; i++) {
            if (i > 0) res += ",";
            res += elem[i];
        }
        res += "}";
        return res;
    }

    public boolean equals(IntSet s) {
        if (size() != s.size()) return false;
        else {
            for (int i = 0; i < size; i++)
                if (!s.contains(elem[i]))
                    return false;
        }
        return true;
    }

    public IntSet intersection(IntSet s) {
        IntSet new_set = new ArrayListIntSet(1);
        for (int i = 0; i < size(); i++)
            if (s.contains(elem[i]) && contains(elem[i]))
                new_set.add(elem[i]);
        return new_set;
    }
}
