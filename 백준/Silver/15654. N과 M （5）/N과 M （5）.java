import java.io.*;
import java.util.*;

/**
 * n과 m (5)
 * 서로 다른 자연수, m개 수열
 */
public class Main {

    static final int MAX_N = 8;

    static int n, m;
    static int[] arr = new int[MAX_N];
    static boolean[] visited = new boolean[MAX_N + 1];
    static int[] record = new int[MAX_N];

    static StringBuilder sb = new StringBuilder();

    public static void func(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++)
                sb.append(record[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                record[depth] = arr[i];
                visited[i] = true;
                func(depth + 1);
                visited[i] = false;
            }
        }
    }// end of func

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        func(0);

        System.out.print(sb.toString());
    }// end of main
}// end of class
