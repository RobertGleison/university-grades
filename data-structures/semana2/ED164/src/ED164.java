import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ED164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfWords = sc.nextInt();
//        The real manner to do this instead of this complicated data structure binary tree
        Set<String> words = new HashSet<>();
        sc.nextLine();
        for (int i = 0; i < numberOfWords; i++) {
            words.add(sc.nextLine());
        }
        System.out.println(words.size());
        }
////        Using the binary tree
//    public static void main(String[] args) {
//        BSTree<String> words = new BSTree<>();
//        Scanner sc = new Scanner(System.in);
//        int numbofWords = sc.nextInt();
//        sc.nextLine();
//        for (int i = 0; i <numbofWords; i++) {
//            words.insert(sc.nextLine());
//        }
//        System.out.println(words.numberNodes());
//    }


}