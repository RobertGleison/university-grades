public class ED211 {
    public static int countEven(BTree<Integer> n) {
        return calculateEven(n.getRoot());
    }

    private static int calculateEven(BTNode<Integer> n) {
        if (n == null) return 0;
        int count = 0;
        if (n.getValue() % 2 == 0) count = 1;
        if (n.getRight() != null) count += calculateEven(n.getRight());
        if (n.getLeft() != null) count += calculateEven(n.getLeft());
        return count;
    }
}

