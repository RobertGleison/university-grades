import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ED172 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new TreeMap<>();

        String text = sc.nextLine();
        String[] words = text.split(" ");
        while (sc.hasNextLine()) {
            for (int i = 0; i < words.length; i++) {
                if (!map.containsKey(words[i])) map.put(words[i], 1);
                else {
                    int temp = map.get(words[i]);
                    map.replace(words[i], temp, temp + 1);
                }
            }
            text = sc.nextLine();
            words = text.split(" ");
        }
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) map.put(words[i], 1);
            else {
                int temp = map.get(words[i]);
                map.replace(words[i], temp, temp + 1);
            }
        }
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}


