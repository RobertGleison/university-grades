public class BTree<T> {
    private BTNode<T> root;
    BTree() {
        root = null;
    }

    public BTNode<T> getRoot() {return root;}
    public void setRoot(BTNode<T> r) {root = r;}

    public boolean isEmpty() {
        return root == null;
    }

    public int numberNodes() {
        return numberNodes(root);
    }

    private int numberNodes(BTNode<T> n) {
        if (n == null) return 0;
        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    public int depth() {
        return depth(root);
    }

    private int depth(BTNode<T> n) {
        if (n == null) return -1;
        return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(BTNode<T> n, T value) {
        if (n == null) return false;
        if (n.getValue().equals(value)) return true;
        return contains(n.getLeft(), value) || contains(n.getRight(), value);
    }

    public void printPreOrder() {
        System.out.print("PreOrder:");
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(BTNode<T> n) {
        if (n==null) return;
        System.out.print(" " + n.getValue() );
        printPreOrder(n.getLeft());
        printPreOrder(n.getRight());
    }

    public void printInOrder() {
        System.out.print("InOrder:");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(BTNode<T> n) {
        if (n==null) return;
        printInOrder(n.getLeft());
        System.out.print(" " + n.getValue());
        printInOrder(n.getRight());
    }

    public void printPostOrder() {
        System.out.print("PostOrder:");
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(BTNode<T> n) {
        if (n==null) return;
        printPostOrder(n.getLeft());
        printPostOrder(n.getRight());
        System.out.print(" " + n.getValue());
    }

    //-------------------------------------------------------------------------
    //Created by me

    public int numberLeafs(){
        return calculateLeafs(root);
    }

    private int calculateLeafs(BTNode<T> n){
        if(n==null) return 0;
        if(n.getLeft() == null && n.getRight()==null) return 1;
        return calculateLeafs(n.getRight()) + calculateLeafs(n.getLeft());
    }

    public boolean strict(){
        return isStrict(root);
    }

    private boolean isStrict(BTNode<T> n){
        if(n==null) return true;
        if(n.getLeft() == null && n.getRight()==null) return true;
        if(n.getLeft() == null && n.getRight()!=null) return false;
        if(n.getLeft() != null && n.getRight()==null) return false;
        return (isStrict(n.getRight()) && isStrict(n.getLeft()));
    }

    public T path(String path){
        return getPathResult(root, path);
    }

    private T getPathResult(BTNode<T> n, String path){
        if(path.equals("")) path=path+" ";
        if(path.charAt(0) == 'R') return n.getValue();
        if(path.charAt(0) == 'E') return getPathResult(n.getLeft(), path.substring(1));
        if(path.charAt(0) == 'D') return getPathResult(n.getRight(), path.substring(1));
        return n.getValue();
    }

    public int nodesLevel(int k){
        return calculateNodesLevel(root, k);
    }

    private int calculateNodesLevel(BTNode<T> n, int k){
            if(k==0) return 1;
            if(n.getLeft()==null && n.getRight()!=null) return calculateNodesLevel(n.getRight(), k-1);
            if(n.getLeft()!=null && n.getRight()==null) return calculateNodesLevel(n.getLeft(), k-1);
            if(n.getLeft()==null && n.getRight()==null) return 0;
            return calculateNodesLevel(n.getRight(), k-1) + calculateNodesLevel(n.getLeft(), k-1);
        }
    }


