import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        String[] responses = new String[lines];
        sc.nextLine();
        for (int i = 0; i < lines; i++) {
            String line = sc.nextLine();
            String filteredLine = line.replaceAll("[^a-zA-Z]", "").toLowerCase();
            responses[i] = isPalindrome(filteredLine);
        }
        System.out.println(lines);
        for (String s : responses) {
            System.out.println(s);
        }
        sc.close();
    }


    public static String isPalindrome(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != line.charAt(line.length()-1-i)) {
                return "nao";
            }
        }
        return "sim";
}
}

