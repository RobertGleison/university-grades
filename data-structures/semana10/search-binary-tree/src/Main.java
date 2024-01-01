import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        // Ler arvore de inteiros em preorder
        Scanner sc = new Scanner(System.in);
        BSTree<Integer> t = LibBTree.readIntTree(sc);
        t.printBFS();
        System.out.println(t.valid());

        // Escrever nos da arvore seguindo varias ordens possiveis
    }
}