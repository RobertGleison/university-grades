
import java.util.Scanner;


class Game {
    final char DEAD = '.';
    final char ALIVE = 'O';
    private int rows, cols;
    private char m[][];

    Game(int r, int c) {
        rows = r;
        cols = c;
        m = new char[r][c];
    }

    public void read(Scanner in) {
        for (int i = 0; i < rows; i++)
            m[i] = in.next().toCharArray();
    }

    public void write() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }

    private int countAlive(int y, int x) {
        int count = 0;

        for (int i = Math.max(0, x - 1); i <= Math.min(rows - 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(cols - 1, y + 1); j++) {
                if (m[i][j] == ALIVE) {
                    count++;
                }
            }
        }
        return count;
    }


    public void iterate() {
        char m2[][] = m;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int result = countAlive(i, j);
                if (result < 2 || result > 2) {
                    if (m2[i][j] == ALIVE) m2[i][j] = DEAD;
                } else {
                    if (result >= 2 && result < 4) {
                        if (m2[i][j] == DEAD) m2[i][j] = ALIVE;
                    }
                }
            }
        }
        m = m2;
    }

}


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rows = in.nextInt();
        int cols = in.nextInt();
        int n = in.nextInt();

        Game g = new Game(rows, cols);
        g.read(in);
        for (int i = 0; i < n; i++) {
            g.iterate();
        }
        g.write();

        in.close();
    }
}