import java.util.Scanner;

public class FloodFill {
    public static int rows;            // Numero de linhas
    public static int cols;            // Numero de colunas
    public static char[][] m;          // Matriz de celulas
    public static boolean[][] visited; // Saber se uma dada posicao ja foi visitada

    public static int t(int y, int x) {
        if (y < 0 || y >= rows || x < 0 || x >= cols) return 0;
        if (visited[y][x]) return 0;
        visited[y][x] = true;
        if (m[y][x] == '.') return 0;
        int count = 1;
        count += t(y - 1, x);
        count += t(y + 1, x);
        count += t(y, x + 1);
        count += t(y, x - 1);
        count += t(y - 1, x - 1);
        count += t(y + 1, x + 1);
        count += t(y + 1, x - 1);
        count += t(y - 1, x + 1);
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();
        for (int j = 0; j < cases; j++) {
            rows = in.nextInt();
            cols = in.nextInt();
            m = new char[rows][cols];
            visited = new boolean[rows][cols];
            for (int i = 0; i < rows; i++)
                m[i] = in.next().toCharArray();
            int max = 0;
            for (int i = 0; i < rows; i++) {
                for (int k = 0; k < rows; k++) {
                    int result = FloodFill.t(i,k);
                    max = Math.max(max, result);
                }
            }
            System.out.println(max);
        }
    }}