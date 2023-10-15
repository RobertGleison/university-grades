//The implementation only works when it is known that x falls within the range of 1 to n.

public class BooleanArrayintSet implements IntSet {
    private boolean[] isElement;
    private int size;

    public BooleanArrayintSet(int n) {
        this.isElement = new boolean[n+1];
        this.size = 0;
    }

    @Override
    public boolean contains(int x) {
        return isElement[x];
    }

    @Override
    public boolean add(int x) {
        if (!contains(x)) {
            isElement[x]=true;
            size++;
            return true;
        }
        else return false;
    }


    @Override
    public boolean remove(int x) {
        if(contains(x)){
            isElement[x] =false;
            size--;
            return true;
        }
        else return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 1; i < isElement.length; i++) {
            isElement[i] = false;
        }
        size = 0;
    }

    @Override
    public boolean equals(IntSet s) {
        if (size() != s.size()) return false;
        else {
            for (int i = 1; i <= size; i++)
                if (!s.contains(i) && contains(i))
                    return false;
        }
        return true;
    }

    @Override
    public IntSet intersection(IntSet s) {
       IntSet intSet = new BooleanArrayintSet(Math.min(isElement.length, s.size()));
       for(int i = 1; i<= isElement.length;i++){
           if(s.contains(i) && contains(i)){
               intSet.add(i);
           }
       }
       return intSet;
    }

    @Override
    public String toString() {
        String res = "{";
        for (int i = 0; i < isElement.length; i++) {
            if (i > 0) res += ",";
            res += isElement[i];
        }
        res += "}";
        return res;
    }
}
