public class ED213 {

    private static String response = "";
    public static String maxSum(BTree<Integer> t) {;
        int sum = calculateMaxSum(t.getRoot(), "");
        return response;
    }

    private static int calculateMaxSum(BTNode<Integer> n, String path) {
        if (n.getLeft() == null && n.getRight() == null) return n.getValue();
        if (n.getLeft() == null && n.getRight() != null)
            return n.getValue() + calculateMaxSum(n.getRight(), path + "D");
        if (n.getLeft() != null && n.getRight() == null) return n.getValue() + calculateMaxSum(n.getLeft(), path + "E");
        if (calculateMaxSum(n.getLeft(), path + "E") >= calculateMaxSum(n.getRight(), path + "D")){
            response = path;
            return n.getValue() + calculateMaxSum(n.getLeft(), path + "E");
        }
        else {
            response = path;
            return n.getValue() + calculateMaxSum(n.getRight(), path + "D");
        }
    }
}
