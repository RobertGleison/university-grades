import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        Soup soup = new Soup(rows, columns);
        soup.read(sc);

        int words = sc.nextInt();
        String[] array = new String[words];
        for (int i = 0; i < words; i++) {
            array[i] = sc.next();
        }
        soup.find(array);
    }
}

class Soup {
    public int rows;
    public int columns;
    public char[][] puzzle;

    public Soup(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.puzzle = new char[rows][columns];
    }

    public void read(Scanner sc) {
        for (int i = 0; i < rows; i++) {
            String line = sc.next();
            for (int j = 0; j < columns; j++) {
                puzzle[i][j] = line.charAt(j);
            }
        }
    }

    public void find(String[] array) {
        for (int i = 0; i < array.length; i++) {
            verify(array[i]);
        }
    }

    public void verify(String word) {

        }


    }