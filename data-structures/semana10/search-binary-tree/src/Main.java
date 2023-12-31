import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        // Ler arvore de inteiros em preorder
        Scanner in = new Scanner(System.in);
        BSTree<Integer> t = new BSTree<>();

        t.insert(6);
        t.insert(3);
        t.insert(1);
        t.insert(4);
        t.insert(2);
        t.insert(10);
        t.insert(8);
        t.insert(42);
        t.insert(7);
        t.insert(23);
        t.insert(54);
        System.out.println(t.getRoot().getValue());
        t.printDFS();
        t.printBFS();
        System.out.println(t.countBetween(5,44));
        System.out.println(t.maxValue());
        System.out.println(t.minValue());

        // Escrever nos da arvore seguindo varias ordens possiveis
    }
}