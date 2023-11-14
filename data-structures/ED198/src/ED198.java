import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ED198 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        sc.nextLine();
        int[] array = (Arrays.stream(sc.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray());
        System.out.println(soma(array));
        sc.close();
    }

    public static int soma(int[] nums) {
        int maxSoma = Integer.MIN_VALUE;
        int somaAtual = 0;

        for (int num : nums) {
            somaAtual = Math.max(num, somaAtual + num);
            maxSoma = Math.max(maxSoma, somaAtual);
        }
        return maxSoma;
    }
}