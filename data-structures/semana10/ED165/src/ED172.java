import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ED172 {
    public static void main(String[] args) {
        import java.util.Arrays;
import java.util.Scanner;

public class ED165 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BSTree<Integer> tree = new BSTree<>();
        int numbersQuantity = sc.nextInt();
        sc.nextLine();
        int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbersQuantity; i++) {
            for (int j = 0; j <numbersQuantity; j++) {
                tree.insert(numbers[i]+numbers[j]);
            }
        }

        int numberOfCases = sc.nextInt();
        sc.nextLine();
        int[] cases = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i <numberOfCases; i++) {
            if(tree.contains(cases[i])){
                System.out.println(cases[i] + ": sim");
            }
            else System.out.println(cases[i] + ": nao");
        }
    }
}
}


