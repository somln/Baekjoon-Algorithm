import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int n;
    static int m;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        func(1, 0);  // 1부터 시작해서 수열 생성
        System.out.println(sb);
    }

    public static void func(int start, int depth) {
        if (depth == m) {  // 수열의 길이가 m에 도달하면 출력
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;  // 숫자 선택
            func(i + 1, depth + 1);  // 다음 숫자는 i보다 큰 값 선택
        }
    }
}
