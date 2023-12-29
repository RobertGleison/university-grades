import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int setSize = sc.nextInt();
        Set<Integer> numbers = new HashSet<>();
        Map<Integer, String> result = new HashMap<>();

        for (int i = 0; i <setSize; i++) {
            numbers.add(sc.nextInt());
        }
        int[] numbersStorage = Arrays.stream(Arrays.stream(sc.nextLine()
                                                   .split(" "))
                                                   .mapToInt(Integer::parseInt)
                                                   .toArray()).toArray();

        for (int i = 0; i <; i++) {
            for (int j = 0; j < ; j++) {

            }
        }




    }
}