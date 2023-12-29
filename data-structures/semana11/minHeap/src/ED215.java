import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ED215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int events = sc.nextInt();
        List<Person> response = new ArrayList<>(events);
        MinHeap<Person> buyers = new MinHeap<>(events);
        sc.nextLine();
        for (int i = 0; i <events; i++) {
            String[] tempArray = sc.nextLine().split(" ");
            if(tempArray[0].equals("OFERTA")){
                buyers.insert(new Person(tempArray[1], Integer.parseInt(tempArray[2])));
            }
            else {
                response.add(buyers.removeMin());
            }
        }
        response.forEach(System.out::println);
    }
}

class Person implements Comparable<Person> {
    private String name;
    private Integer value;

    public Person(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public int compareTo(Person o) {
        return o.getValue().compareTo(getValue());
    }

    @Override
    public String toString() {
        return getValue() + " " + getName();
    }
}
