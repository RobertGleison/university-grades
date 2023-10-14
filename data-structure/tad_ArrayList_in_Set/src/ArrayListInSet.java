import java.util.Arrays;

public class ArrayListInSet implements IntSet {
    private int[] capacity;


    public ArrayListInSet(int size) {
        this.capacity = new int[size];
    }

    public int[] getCapacity() {
        return capacity;
    }

    public void setCapacity(int[] capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean contains(int x) {
        for (int i : capacity) {
            if (x == i) return true;
        }
        return false;
    }

    @Override
    public boolean add(int x) {
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] == x) {
                return true;
            }
            if (capacity[i] == 0) {
                capacity[i] = x;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int x) {
        int count = 0;
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] == x) {
                capacity[i] = 0;
                count = 1;
            }
        }
        if (count == 1) return true;
        return false;
    }


    @Override
    public int size() {
        int count = 0;
        for (int i : capacity) {
            if (i != 0) count++;
        }
        return count;
    }

    @Override
    public void clear() {
        for (int i : capacity) {
            i = 0;
        }
    }

    @Override
    public boolean equals(IntSet s) {
        for (int i : capacity) {
            if (!s.contains(i)) return false;
        }
        return true;
    }

    @Override
    public IntSet intersection(IntSet s) {
        int[] array = new int[Math.max(this.size(), s.size())];
        for (int i = 0; i < this.size(); i++) {
            if (s.contains(capacity[i])) array[i] = capacity[i];
        }
        IntSet intSet = new ArrayListInSet(100);
        for (int i : array)
            intSet.add(i);
        return intSet;
    }

    public int[] minimizeArray() {
        int count = 0;
        for (int i : capacity) {
            if (i != 0) count++;
        }
        int[] newArray = new int[count];
        for (int i = 0; i < count; i++) {
            if (capacity[i] != 0)
                newArray[i] = capacity[i];
        }
        return newArray;
    }

    @Override
    public String toString() {
        return "{" + Arrays.toString(minimizeArray()) +
                '}';
    }
}
