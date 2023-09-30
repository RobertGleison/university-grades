import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int firstNumber = sc.nextInt();
        int lastNumber = sc.nextInt();

        int count = countPrimes(firstNumber, lastNumber);
        System.out.println(count);

    }

    public static int countPrimes(int firstNumber, int lastNumber) {
        boolean[] isPrime = new boolean[lastNumber + 1];
        for (int i = 2; i <= lastNumber; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= lastNumber; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= lastNumber; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        int count = 0;
        for (int i = Math.max(2, firstNumber); i <= lastNumber; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}
