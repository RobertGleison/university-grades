import javax.swing.tree.TreeNode;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTree<T extends Comparable<? super T>> {
    private BSTNode<T> root;

    BSTree() {
        root = null;
    }

    public BSTNode<T> getRoot() {
        return root;
    }

    public void setRoot(BSTNode<T> r) {
        root = r;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        setRoot(null);
    }

    public int numberNodes() {
        return numberNodes(getRoot());
    }

    private int numberNodes(BSTNode<T> n) {
        if (n == null) return 0;
        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean contains(T value) {
        return contains(getRoot(), value);
    }

    private boolean contains(BSTNode<T> n, T value) {
        if (n == null) return false;
        if (value.compareTo(n.getValue()) < 0) // menor? sub-arvore esquerda
            return contains(n.getLeft(), value);
        if (value.compareTo(n.getValue()) > 0) // maior? sub-arvore direita
            return contains(n.getRight(), value);
        return true; // se nao e menor ou maior, e porque e igual
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Devolve true se conseguiu inserir, false caso contrario
    public boolean insert(T value) {
        if (contains(value)) return false;
        setRoot(insert(getRoot(), value));
        return true;
    }

    private BSTNode<T> insert(BSTNode<T> n, T value) {
        if (n == null)
            return new BSTNode<T>(value, null, null);
        else if (value.compareTo(n.getValue()) < 0)
            n.setLeft(insert(n.getLeft(), value));
        else if (value.compareTo(n.getValue()) > 0)
            n.setRight(insert(n.getRight(), value));
        return n;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Devolve true se conseguiu remover, false caso contrario
    public boolean remove(T value) {
        if (!contains(value)) return false;
        setRoot(remove(getRoot(), value));
        return true;
    }

    // Assume-se que elemento existe (foi verificado antes)
    private BSTNode<T> remove(BSTNode<T> n, T value) {
        if (value.compareTo(n.getValue()) < 0)
            n.setLeft(remove(n.getLeft(), value));
        else if (value.compareTo(n.getValue()) > 0)
            n.setRight(remove(n.getRight(), value));
        else if (n.getLeft() == null) // Nao tem filho esquerdo
            n = n.getRight();
        else if (n.getRight() == null) // Nao tem filho direito
            n = n.getLeft();
        else { // Dois fihos: ir buscar maximo do lado esquerdo
            BSTNode<T> max = n.getLeft();
            while (max.getRight() != null) max = max.getRight();
            n.setValue(max.getValue()); // Substituir valor removido
            // Apagar valor que foi para lugar do removido
            n.setLeft(remove(n.getLeft(), max.getValue()));
        }
        return n;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Altura da arvore
    public int depth() {
        return depth(getRoot());
    }

    private int depth(BSTNode<T> n) {
        if (n == null) return -1;
        return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Imprimir arvore em PreOrder
    public void printPreOrder() {
        System.out.print("PreOrder:");
        printPreOrder(getRoot());
        System.out.println();
    }

    private void printPreOrder(BSTNode<T> n) {
        if (n == null) return;
        System.out.print(" " + n.getValue());
        printPreOrder(n.getLeft());
        printPreOrder(n.getRight());
    }

    // Imprimir arvore em InOrder
    public void printInOrder() {
        System.out.print("InOrder:");
        printInOrder(getRoot());
        System.out.println();
    }

    private void printInOrder(BSTNode<T> n) {
        if (n == null) return;
        printInOrder(n.getLeft());
        System.out.print(" " + n.getValue());
        printInOrder(n.getRight());
    }

    // Imprimir arvore em PostOrder
    public void printPostOrder() {
        System.out.print("PostOrder:");
        printPostOrder(getRoot());
        System.out.println();
    }

    private void printPostOrder(BSTNode<T> n) {
        if (n == null) return;
        printPostOrder(n.getLeft());
        printPostOrder(n.getRight());
        System.out.print(" " + n.getValue());
    }

    // Imprimir arvore numa visita em largura (usando TAD Fila)
    public void printBFS() {
        System.out.print("BFS:");
        Queue<BSTNode<T>> q = new LinkedList<>();
        q.offer(getRoot());
        while (!q.isEmpty()) {
            BSTNode<T> cur = q.poll();
            if (cur != null) {
                System.out.print(" " + cur.getValue());
                q.offer(cur.getLeft());
                q.offer(cur.getRight());
            }
        }
        System.out.println();
    }

    // Imprimir arvore numa visita em largura (usando TAD Pilha)
    public void printDFS() {
        System.out.print("DFS:");
        Stack<BSTNode<T>> q = new Stack<>();
        q.push(getRoot());
        while (!q.isEmpty()) {
            BSTNode<T> cur = q.pop();
            if (cur != null) {
                System.out.print(" " + cur.getValue());
                q.push(cur.getLeft());
                q.push(cur.getRight());
            }
        }
        System.out.println();
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public T minValue() {
        return seekMinValue(getRoot());
    }

    private T seekMinValue(BSTNode<T> n) {
        if (n.getLeft() == null && n.getRight() == null) {
            return n.getValue();
        } else {
            T leftMin = (n.getLeft() == null) ? n.getValue() : (n.getValue().compareTo(seekMinValue(n.getLeft())) <= 0) ? n.getValue() : seekMinValue(n.getLeft());
            T rightMin = (n.getRight() == null) ? n.getValue() : (n.getValue().compareTo(seekMinValue(n.getRight())) <= 0) ? n.getValue() : seekMinValue(n.getRight());
            return (leftMin.compareTo(rightMin) <= 0) ? leftMin : rightMin;
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public T maxValue() {
        return seekMaxValue(getRoot());
    }

    private T seekMaxValue(BSTNode<T> n) {
        if (n.getLeft() == null && n.getRight() == null) {
            return n.getValue();
        } else {
            T leftMax = (n.getLeft() == null) ? n.getValue() : (n.getValue().compareTo(seekMaxValue(n.getLeft())) >= 0) ? n.getValue() : seekMaxValue(n.getLeft());
            T rightMax = (n.getRight() == null) ? n.getValue() : (n.getValue().compareTo(seekMaxValue(n.getRight())) >= 0) ? n.getValue() : seekMaxValue(n.getRight());
            return (leftMax.compareTo(rightMax) >= 0) ? leftMax : rightMax;
        }
    }

    public int countBetween(T a, T b) {
        if (numberNodes() < 2 || getRoot() == null) return 0;
        return countBetweenValues(a, b, getRoot());
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private int countBetweenValues(T a, T b, BSTNode<T> n) {
        if (n.getRight() == null && n.getLeft() == null) return (isInBetween(n, a, b)) ? 1 : 0;
        if (n.getRight() == null && n.getLeft() != null)
            return (isInBetween(n, a, b)) ? 1 + countBetweenValues(a, b, n.getLeft()) : countBetweenValues(a, b, n.getLeft());
        if (n.getRight() != null && n.getLeft() == null)
            return (isInBetween(n, a, b)) ? 1 + countBetweenValues(a, b, n.getRight()) : countBetweenValues(a, b, n.getRight());
        return (isInBetween(n, a, b)) ? 1 + countBetweenValues(a, b, n.getRight()) + countBetweenValues(a, b, n.getLeft()) : countBetweenValues(a, b, n.getRight()) + countBetweenValues(a, b, n.getLeft());
    }

    private boolean isInBetween(BSTNode<T> n, T a, T b) {
        return (n.getValue().compareTo(a) > -1 && n.getValue().compareTo(b) < 1);
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean valid() {
        return isValid(getRoot());
    }

    private boolean isValid(BSTNode<T> n) {
        T maxValue, minValue;
        if (n == null || (n.getRight() == null && n.getLeft() == null)) return true;

        //In case of right child node is null
        if (n.getLeft() != null && n.getRight() == null) {
            maxValue = getMaxValue(n.getLeft());
            if((maxValue.compareTo(n.getValue()) > 0 || !(n.getLeft().getValue().compareTo(n.getValue()) < 0))) return false;
            return isValid(n.getLeft());}

        //In case of left child node is null
        if (n.getLeft() == null && n.getRight() != null) {
            minValue = getMinValue(n.getRight());
            if((minValue.compareTo(n.getValue()) < 0 || !(n.getRight().getValue().compareTo(n.getValue()) > 0))) return false;
            return isValid(n.getRight());}

        if (n.getRight().getValue().compareTo(n.getValue()) < 0 || n.getLeft().getValue().compareTo(n.getValue()) > 0) return false;

        //In case of no child nod is null
        minValue = n.getRight() == null ? n.getValue() : getMinValue(n.getRight());
        maxValue = n.getLeft() == null ? n.getValue() : getMaxValue(n.getLeft());
        if (n.getValue().compareTo(maxValue) < 0 || n.getValue().compareTo(minValue) > 0) return false;
        return isValid(n.getLeft()) && isValid(n.getRight());}

    private T getMinValue(BSTNode<T> n) {
        while (n.getLeft() != null) n = n.getLeft();
        return n.getValue();
    }

    private T getMaxValue(BSTNode<T> n) {
        while (n.getRight() != null) n = n.getRight();
        return n.getValue();
    }


}



