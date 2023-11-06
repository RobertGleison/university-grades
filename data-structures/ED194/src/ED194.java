import java.util.Stack;

public class ED194 {
//    public static void main(String[] args) {
//        Stack<Integer> s = new Stack<>();
//        Stack<Integer> s2 = new Stack<>();
//        s.push(0);
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        s.push(4);
//        s.push(5);
//        reverse(s, 3);
//
//    }
    //Change Stack to MyStack
    public static void reverse(Stack<Integer> s, int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = s.pop();
        }
        for (int i = 0; i < n; i++) {
            s.push(array[i]);
        }
    }
}
