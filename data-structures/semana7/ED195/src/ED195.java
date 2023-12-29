import java.util.Stack;

public class ED195 {
    public static void main(String[] args) {

        System.out.println(balanced("()()()()()"));
    }


    public static boolean balanced(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< s.length();i++){
            if(stack.empty()){
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.peek() == '(' && s.charAt(i) == ')') stack.pop();
            else if(stack.peek() == '[' && s.charAt(i) == ']') stack.pop();
            else stack.push(s.charAt(i));
        }
        return stack.empty();
    }
}