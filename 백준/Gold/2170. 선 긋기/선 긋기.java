import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][2];
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(a, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
        int start = a[0][0];
        int end = a[0][1];
        int ans = 0;
        
        for(int i=1; i<n; i++) {
            if(end >= a[i][0]) {
                end = Math.max(end, a[i][1]);
            } else {
                ans += end - start;
                start = a[i][0];
                end = a[i][1];
            }
        }
        ans += end - start;
        
        System.out.println(ans);
    }
}