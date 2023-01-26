import java.io.*;

/**
 * N-Queen, 9663
 * 
 * N * N 체스판에 퀸 N개를 서로 공격할 수 없게 놓는 문제
 * 
 * N이 주어졌을 때, 퀸을 노흔 방법의 수 출력
 * 
 * 
 * 풀이 2.
 * 하나씩 놓을 수 있을 때만 놓는다
 */

public class Main {
    static final int MAX_N = 14;

    static int n;
    static int ans = 0;

    static boolean[][] map;
    static int[] col;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        col = new int[n + 1];
    }// end of init

    public static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) // 열확인
            return true;
        if (r1 - c1 == r2 - c2) // 좌상단 우하단의 \ 대각선 확인
            return true;
        if (r1 + c1 == r2 + c2)// 우상단 좌하단의 / 대각선 확인
            return true;
        return false;
    }

    public static void func(int row) {
        if (row == n + 1) {
            ans++;
            return;
        }

        // 열 하나씩 확인
        for (int c = 1; c <= n; c++) {
            boolean possible = true; // queen을 놓을 수 있는 여부
            // 고른 하나의 열에서 가능한 행 확인
            for (int i = 1; i <= row; i++) {
                // 앞서 고른 행과 열(row, c)에 대해 새로 고른 행과 열(i, col[i])이 가능한지 판단
                if (attackable(row, c, i, col[i])) {
                    possible = false;
                    break;
                }
            }
            // 가능하면 row행 c열은 가능한 경우
            if (possible) {
                col[row] = c;
                func(row + 1);
                col[row] = 0;
            }
        }
    }// end of func

    public static void sol() {
        func(1);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main
}// end of class
