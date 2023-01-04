import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= TC; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];

            inputMap(n, map, br);

            int[][][] res = new int[3][n][n];
            for (int i = 0; i < 3; i++) {
                map = rotate90(map);
                res[i] = copyMap(map);
            }

            printResult(tc, res, sb);

        } // end of TC

        System.out.println(sb.toString());
    }// end of main

    public static void inputMap(int n, int[][] map, BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }// end of inputMap

    public static int[][] rotate90(int[][] map) {
        int n = map.length;
        int[][] tmp = copyMap(map);

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int nx = y;
                int ny = (n - 1) - x;
                map[nx][ny] = tmp[x][y];
            }
        }

        return map;
    }// end of rotate90

    public static int[][] copyMap(int[][] map) {
        int n = map.length;
        int[][] copyMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, n);
        }
        return copyMap;
    }

    public static void printResult(int tc, int[][][] res, StringBuilder sb) {
        sb.append("#").append(tc).append("\n");

        for (int j = 0; j < res[0].length; j++) {
            for (int i = 0; i < res.length; i++) {
                for (int k = 0; k < res[0][0].length; k++) {
                    sb.append(res[i][j][k]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
    }

}// end of class
