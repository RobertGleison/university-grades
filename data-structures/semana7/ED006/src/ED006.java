import java.util.Scanner;

public class ED006 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < cases; i++) {
            String line = sc.nextLine();
            sc.nextInt();
            String[] names = sc.nextLine().trim().split(" ");
            Game.gameCalculator(line, names);
        }
        sc.close();
    }

    public static class Game {

        public static int wordsInString(String line) {
            String[] words = line.trim().split(" ");
            return words.length;
        }

        public static void gameCalculator(String line, String[] names) {
            CircularLinkedList<String> cList = new CircularLinkedList<>();
            for (String name : names)
                cList.addLast(name.toLowerCase());
            while (cList.size() != 1) {
                for (int k = 0; k < wordsInString(line)-1; k++)
                    cList.rotate();
                cList.removeFirst();
            }
            printResult(cList);
        }

        public static void printResult(CircularLinkedList<String> cList) {
            if (cList.getFirst().equals("carlos"))
                System.out.println("O Carlos nao se livrou");
            else
                System.out.println("O Carlos livrou-se (coitado do " + cList.getFirst() + "!)");
        }
    }
}