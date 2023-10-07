import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag = sc.nextInt();
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        TurtleWorld t = new TurtleWorld(flag, rows, columns);

        String instruction;
        do {
            instruction = sc.nextLine();
            t.runInstruction(instruction);
        }
        while (!instruction.equals("end"));




    }
}

class TurtleWorld{
    public int flag;
    public int rows;
    public int columns;
    public char[][] grid;

    public TurtleWorld(int flag, int rows, int columns){
        this.flag = flag;
        this.rows = rows;
        this.columns = columns;
        this.grid = new char[rows][columns];
    }

    public void runInstruction(String instruction){
        String[] array = instruction.split(" ");
        switch (array[0].charAt(0)){
            case 'U':
                break;
            case 'D':
                break;
            case 'L':
                break;
            case 'R':
                break;
            case 'F':
                break;
            default:
                System.out.println("This instruction do not exist");
        }
    }
}