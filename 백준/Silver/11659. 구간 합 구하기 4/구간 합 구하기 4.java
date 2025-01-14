import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] a = new int[n + 1];
        int[] d = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            d[i] = d[i - 1] + a[i]; // 누적 합 계산
        }
        
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            bw.write((d[j] - d[i - 1]) + "\n"); 
        }
        
        bw.flush(); 
        br.close();
        bw.close();
    }
}


/*
시간 복잡도 비교:

1. 직접 구간 합 계산:
   - 한 쿼리에서 [i, j]의 합을 직접 계산: O(j - i + 1)
   - m개의 쿼리 처리: O(m * 평균 구간 길이)
   - 최악의 경우 (모든 쿼리가 [1, n] 범위를 포함): O(m * n)
   - 비효율적이며, 특히 n과 m이 클 경우 성능 문제가 발생.

2. 누적 합(DP) 사용:
   - 사전 처리: 누적 합 배열 계산 O(n)
   - 각 쿼리 처리: O(1) (d[j] - d[i-1] 계산)
   - m개의 쿼리 처리: O(m)
   - 전체 시간 복잡도: O(n + m)
   - 사전 처리가 필요하지만, 각 쿼리가 매우 빠르게 처리됨.

*/
