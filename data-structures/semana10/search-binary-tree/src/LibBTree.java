import java.util.Scanner;

public class LibBTree {
    public static BSTree<Integer> readIntTree(Scanner in) {
        BSTree<Integer> t = new BSTree<Integer>();
        t.setRoot(readIntNode(in));
        return t;
    }

    private static BSTNode<Integer> readIntNode(Scanner in) {
        String s = in.next();
        if (s.equals("N")) return null;
        Integer value = Integer.parseInt(s);
        BSTNode<Integer> left = readIntNode(in);
        BSTNode<Integer> right = readIntNode(in);
        return new BSTNode<Integer>(value, left, right);
    }
}