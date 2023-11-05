import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList<String> list = new CircularLinkedList();
        int cases = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cases; i++) {
            String phrase = sc.nextLine();
            String[] phraseWords = phrase.split(" ");
            int numberOfPersons = sc.nextInt();
            String[] persons;
            String personsString = sc.nextLine();
            persons = personsString.substring(1).split(" ");
            for (String person : persons) {
                list.addLast(person.toLowerCase());
            }
            for (int r = 0; r < phraseWords.length; r++) {
                if(list.size()==1){
                    if(list.getFirst().equals("carlos")) System.out.println("O Carlos nao se livrou");
                    else System.out.println("O Carlos livrou-se (coitado do " + list.getFirst() + "!)");
                    break;
                }
                for (int j = 0; j < phraseWords.length; j++)
                    list.rotate();
                list.removeLast();
            }
        }
    }
}