import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); 
        int[] a = new int[n];                 
        int[] ans = new int[n];                

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        // 역방향 탐색
        for (int i = n - 1; i >= 0; i--) {
            // 스택에서 현재 값보다 작거나 같은 값을 제거
            while (!stack.isEmpty() && stack.peek() <= a[i]) {
                stack.pop();
            }

            // 스택이 비어 있으면 -1, 그렇지 않으면 스택의 맨 위 값을 결과 배열에 저장
            ans[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(a[i]);
        }

        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
    }
}
