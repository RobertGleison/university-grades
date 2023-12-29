import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        // Ler arvore de inteiros em preorder
        Scanner in = new Scanner(System.in);
        BSTree<Integer> t = LibBTree.readIntTree(in);

        // Escrever resultado de chamada a alguns metodos
        System.out.println(t.valid());

        // Escrever nos da arvore seguindo varias ordens possiveis
    }
}