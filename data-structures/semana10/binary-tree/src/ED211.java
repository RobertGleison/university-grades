public class ED211 {
    public static int countEven(BTree<Integer> n) {
        return calculateEven(n.getRoot());
    }

    private static int calculateEven(BTNode<Integer> n) {
        if(n==null) return 0;
        if(n.getValue() % 2 != 0) return calculateEven(n.getRight()) + calculateEven(n.getLeft());
        return 1 + calculateEven(n.getRight()) + calculateEven(n.getLeft());
    }
}
