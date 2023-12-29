public class ED212 {
//    public static int[] sumLevels(BTree<Integer> t) {
//        int[] sumLevel = new int[t.depth() + 1];
//        int count = 0;
//        return calculateSumLevels(t.getRoot(), sumLevel, count);
//    }
//
//    private static int[] calculateSumLevels(BTNode<Integer> n, int[] sumLevel, int count) {
//        if (n == null) return sumLevel;
//        sumLevel[count] += n.getValue();
//        if (n.getLeft() == null && n.getRight() != null) calculateSumLevels(n.getRight(), sumLevel, count + 1);
//        if (n.getLeft() != null && n.getRight() == null) calculateSumLevels(n.getLeft(), sumLevel, count + 1);
//        if (n.getLeft() != null && n.getRight() != null){
//            calculateSumLevels(n.getLeft(), sumLevel, count + 1);
//            calculateSumLevels(n.getRight(), sumLevel, count + 1);
//        }
//        return sumLevel;
//    }

    public static int[] sumLevels(BTree<Integer> t) {
        return calculateLevels(t.getRoot(), new int[t.depth()], 0);
    }

    public static int[] calculateLevels(BTNode<Integer> n, int[] response, int count) {
        if (n == null) return response;
        response[count] += n.getValue();
        calculateLevels(n.getRight(), response, count + 1);
        calculateLevels(n.getLeft(), response, count + 1);
        return response;
    }
}
