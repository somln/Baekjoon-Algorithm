import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];
        int[] c = new int[n + m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int ai = 0, bi = 0;
        for (int i = 0; i < n + m; i++) {
            if (ai == n) {
                c[i] = b[bi++];
            } else if (bi == m) {
                c[i] = a[ai++];
            } else if (a[ai] <= b[bi]) {
                c[i] = a[ai++];
            } else {
                c[i] = b[bi++];
            }
        }


        for (int i = 0; i < n + m; i++) {
            bw.write(c[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}