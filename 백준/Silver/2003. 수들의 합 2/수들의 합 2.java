import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] pfSum = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            pfSum[i] = pfSum[i - 1] + Long.parseLong(st.nextToken());
        }

        int lp = 0, rp = 0;
        int ans = 0;

        while (rp <= n) {
            long csum = pfSum[rp] - pfSum[lp];
            if (csum <= m) {
                if (csum == m) ans++;
                rp++;
            } else {
                lp++;
            }
        }

        System.out.println(ans);
    }
}
