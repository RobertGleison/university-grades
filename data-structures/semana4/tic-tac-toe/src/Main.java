import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int squareSize = sc.nextInt();
        Game g = new Game(squareSize);
        g.read(sc);
        g.check();
        sc.close();
    }}

class Game {
    private int n;
    private char m[][];

    public Game(int n) {
        this.n = n;
        this.m = new char[n][n];
    }

    public void read(Scanner sc) {
        for (int i = 0; i < n; i++) {
            String buffer = sc.next();
            for (int j = 0; j < n; j++) {
                m[i][j] = buffer.charAt(j);
            }
        }
    }

    public void check() {
        for (int i = 0; i < n; i++)
            verify(i, 0, 0, 1);
        for (int j = 0; j < n; j++)
            verify(0, j, 1, 0);
        verify(0, 0, 1, 1);
        verify(0, n - 1, 1, -1);

        if (!finished()) System.out.println("Jogo incompleto");
        else System.out.println("Empate");
    }

    public void verify(int y, int x, int incy, int incx) {
        if (m[y][x] == '.') return;
        char player = m[y][x]; // Get the player's symbol
        for (int i = 0, yy = y, xx = x; i < n; i++, yy += incy, xx += incx) {
            char target = m[yy][xx];
            if (player != target) return;
        }
        win(player);
    }

    public void win(char player) {
        System.out.println("Ganhou o " + player);
        System.exit(0);
    }

    public boolean finished() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == '.') return false;
            }
        }
        return true;
    }
}
