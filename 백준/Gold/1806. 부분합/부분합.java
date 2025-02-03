import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken()); 
        int s = Integer.parseInt(stk.nextToken()); 

        int[] a = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int en = 0;

        for (int st = 0; st < n; st++) {
            while (en < n && sum < s) {
                sum += a[en];
                en++;
            }

            if (sum >= s) {
                min = Math.min(min, en - st);
            }

            sum -= a[st]; 
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
