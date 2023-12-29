import java.util.Scanner;

public class ED201 {
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalTime = sc.nextInt();
        int numberOfMusics = sc.nextInt();
        int[] array = new int[numberOfMusics];
        for (int i = 0; i <numberOfMusics; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(sets(array, totalTime));
    }


    static int sets(int[] v, int totalTime) {
        boolean[] used = new boolean[v.length];
        goSets(0, v, used, totalTime);
        return max;
    }

    static void goSets(int cur, int[] v, boolean[] used, int totalTime) {
        if (cur == v.length) {
            int tempSum = 0;
            for (int i=0; i<v.length; i++)
                if (used[i]) tempSum+=v[i];
            if(tempSum > max && tempSum<totalTime) max = tempSum;
        } else {
            used[cur] = true;      // Subconjuntos que incluem o elemento actual
            goSets(cur+1, v, used, totalTime);
            used[cur] = false;     // Subconjuntos que nao incluem o el. actual
            goSets(cur+1, v, used, totalTime);
        }
    }
}
