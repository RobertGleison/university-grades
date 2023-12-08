import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ler arvore de inteiros em preorder
        Scanner in = new Scanner(System.in);
        BTree<Integer> t = LibBTree.readIntTree(in);

        // Escrever resultado de chamada a alguns metodos
        System.out.println("numberNodes = " + t.numberNodes());
        System.out.println("depth = " + t.depth());
        System.out.println("contains(2) = " + t.contains(2));
        System.out.println("contains(3) = " + t.contains(3));
//        System.out.println(ED212.sumLevels(t));
        System.out.println(ED213.maxSum(t));
//        System.out.println(t.path("DD"));
//        System.out.println(t.nodesLevel(2));
//        System.out.println(ED211.countEven(t));

    }
}