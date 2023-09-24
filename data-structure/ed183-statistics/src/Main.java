import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberQuantity = sc.nextInt();
        int[] array = new int[numberQuantity];

        for (int i = 0; i < numberQuantity; i++) {
            array[i] = sc.nextInt();
        }
        int sum = Arrays.stream(array).reduce(Integer::sum).orElse(0);
        double avg = (double)sum/numberQuantity;
        int min = Arrays.stream(array).min().orElse(0);
        int max = Arrays.stream(array).max().orElse(0);
        int amplitude = max-min;
        System.out.printf("%.2f%n",avg);
        System.out.println(amplitude);
        sc.close();
    }
}