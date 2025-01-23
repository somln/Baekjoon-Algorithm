import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); 

        while (t-- > 0) {
            String p = br.readLine(); 
            int n = Integer.parseInt(br.readLine()); 
            st = new StringTokenizer(br.readLine(), "[],"); 

            LinkedList<Integer> list = new LinkedList<>(); 

            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            boolean isReversed = false; // 방향 플래그
            boolean isError = false;   // 에러 발생 여부

            for (char cmd : p.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed; // 방향 전환
                } else if (cmd == 'D') {
                    if (list.isEmpty()) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        list.removeLast(); 
                    } else {
                        list.removeFirst(); 
                    }
                }
            }

            if (isError) {
                continue; // 에러 발생 시 다음 테스트 케이스로
            }

            sb.append('[');
            while (!list.isEmpty()) {
                if (isReversed) {
                    sb.append(list.removeLast()); // 역방향 출력
                } else {
                    sb.append(list.removeFirst()); // 정방향 출력
                }
                if (!list.isEmpty()) sb.append(','); 
            }
            sb.append(']').append('\n');
        }

        System.out.print(sb); 
    }
}
