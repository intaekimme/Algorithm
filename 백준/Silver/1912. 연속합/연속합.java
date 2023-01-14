import java.io.*;
import java.util.*;

/**
 * 1912. 연속합, dp
 * arr[0] 초기값부터 누적해서 계속 더하여 dp배열에 기록한다.
 * 이전에 누적한 값에 현재 값을 더한 것이 현재값보다 크면 더하고
 * 작으면 현재값부터 새로 더하기 시작한다. 이렇게 최댓값을 갱신한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
