import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int target = (size - 1) / 2;
        int lowerPointer = target;
        int higherPointer = target;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j < lowerPointer || j > higherPointer) {
                    System.out.print(".");
                } else System.out.print("#");
            }
            if (i < target){
                lowerPointer -= 1;
                higherPointer += 1;
            }
            else{
                lowerPointer += 1;
                higherPointer -= 1;
            }
            System.out.println();
        }
    }
}