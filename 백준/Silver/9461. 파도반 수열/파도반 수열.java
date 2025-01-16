import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); 
        long[] d = new long[101];  
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;

        for (int i = 4; i <= 100; i++) {
            d[i] = d[i - 2] + d[i - 3];
        }

        while (t-- > 0) {
            int n = sc.nextInt();  
            System.out.println(d[n]);
        }

        sc.close();
    }
}
