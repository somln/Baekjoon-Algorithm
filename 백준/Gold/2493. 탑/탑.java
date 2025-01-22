import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<int[]> st = new Stack<>();
        st.add(new int[]{100000000, 0});  // 초기값: 높이, 순서

        StringTokenizer stz = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int h = Integer.parseInt(stz.nextToken());
            while (!st.isEmpty() && st.peek()[0] < h) { // 나보다 큰 값이 나올 때까지 pop
                st.pop();
            }
            sb.append(st.peek()[1]).append(" "); 
            st.add(new int[] {h, i});
        }

        System.out.println(sb.toString().trim()); 
    }
}
