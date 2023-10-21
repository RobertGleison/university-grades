public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(2);
        list.addLast(1);
        list.addLast(3);
        list.addLast(4);
        list.addLast(2);
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);


        System.out.println(list);
        list.removeAll(1);
        System.out.println(list);
        System.out.println(list.size());








    }
}