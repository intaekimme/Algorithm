import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>(); // 스택, 사용이유 : 스택의 선입선출이 ~효과가 있다. 그리고 시간복잡도는 O(N)이다.
        Deque<Integer> res = new ArrayDeque<>(); // 정답 넣을 공간
        // 배열의 뒤에서부터 확인
        for (int i = arr.length - 1; i >= 0; i--) {
            // 스택이 비어있지 않다면 top부터 체크
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty())
                    res.addFirst(-1);
                else
                    res.addFirst(stack.peek());
            } else { // 스택이 비어있으면
                res.addFirst(-1);
            }
            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        while (!res.isEmpty()) {
            sb.append(res.pollFirst()).append(" ");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
