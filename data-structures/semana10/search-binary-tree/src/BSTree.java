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
        root = null;
    }

    public int numberNodes() {
        return numberNodes(root);
    }

    private int numberNodes(BSTNode<T> n) {
        if (n == null) return 0;
        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(BSTNode<T> n, T value) {
        if (n == null) return false;
        if (value.compareTo(n.getValue()) < 0) // menor? sub-arvore esquerda
            return contains(n.getLeft(), value);
        if (value.compareTo(n.getValue()) > 0) // maior? sub-arvore direita
            return contains(n.getRight(), value);
        return true; // se nao e menor ou maior, e porque e igual
    }

    // Devolve true se conseguiu inserir, false caso contrario
    public boolean insert(T value) {
        if (contains(value)) return false;
        root = insert(root, value);
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

    // Devolve true se conseguiu remover, false caso contrario
    public boolean remove(T value) {
        if (!contains(value)) return false;
        root = remove(root, value);
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

    // Altura da arvore
    public int depth() {
        return depth(root);
    }

    private int depth(BSTNode<T> n) {
        if (n == null) return -1;
        return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    // Imprimir arvore em PreOrder
    public void printPreOrder() {
        System.out.print("PreOrder:");
        printPreOrder(root);
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
        printInOrder(root);
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
        printPostOrder(root);
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
        q.offer(root);
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
        q.push(root);
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

    public T minValue() {
        return seekMinValue(root);
    }

    private T seekMinValue(BSTNode<T> n) {
        if (n.getLeft() == null && n.getRight() == null) {
            return n.getValue();
        } else if (n.getLeft() == null && n.getRight() != null) {
            return (n.getValue().compareTo(seekMinValue(n.getRight())) <= 0) ? n.getValue() : seekMinValue(n.getRight());
        } else if (n.getLeft() != null && n.getRight() == null) {
            return (n.getValue().compareTo(seekMinValue(n.getLeft())) <= 0) ? n.getValue() : seekMinValue(n.getLeft());
        } else {
            T leftMin = seekMinValue(n.getLeft());
            T rightMin = seekMinValue(n.getRight());
            return (leftMin.compareTo(rightMin) <= 0) ? leftMin : rightMin;
        }
    }

    public T maxValue() {
        return seekMaxValue(root);
    }

    private T seekMaxValue(BSTNode<T> n) {
        if (n.getLeft() == null && n.getRight() == null) {
            return n.getValue();
        } else if (n.getLeft() == null && n.getRight() != null) {
            return (n.getValue().compareTo(seekMaxValue(n.getRight())) >= 0) ? n.getValue() : seekMaxValue(n.getRight());
        } else if (n.getLeft() != null && n.getRight() == null) {
            return (n.getValue().compareTo(seekMaxValue(n.getLeft())) >= 0) ? n.getValue() : seekMaxValue(n.getLeft());
        } else {
            T leftMax = seekMaxValue(n.getLeft());
            T rightMax = seekMaxValue(n.getRight());
            return (leftMax.compareTo(rightMax) >= 0) ? leftMax : rightMax;
        }
    }

    public int countBetween(T a, T b) {
        if (numberNodes() < 2 || root == null) return 0;
        return countBetweenValues(a, b, root);
    }

    private boolean isInBetween(BSTNode<T> n, T a, T b) {
        return (n.getValue().compareTo(a) > -1 && n.getValue().compareTo(b) < 1);
    }

    private int countBetweenValues(T a, T b, BSTNode<T> n) {
        if (n.getRight() == null && n.getLeft() == null) {
            if (isInBetween(n, a, b)) return 1;
            else return 0;
        }
        if (n.getRight() == null && n.getLeft() != null){
            if (isInBetween(n, a, b)) return 1 + countBetweenValues(a, b, n.getLeft());
            else return countBetweenValues(a,b,n.getLeft());}
        if (n.getRight() != null && n.getLeft() == null){
            if (isInBetween(n, a, b)) return 1 + countBetweenValues(a, b, n.getRight());
            else return countBetweenValues(a,b,n.getRight());
        }
        else {
            if (isInBetween(n, a, b)) return 1 + countBetweenValues(a, b, n.getRight()) + countBetweenValues(a,b,n.getLeft());
            else return countBetweenValues(a,b,n.getRight()) + countBetweenValues(a,b,n.getLeft());
        }
    }
}