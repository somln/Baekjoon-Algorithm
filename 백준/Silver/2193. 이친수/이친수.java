import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        long[] d = new long[91];
        // d[i]: i자리 이친수의 개수

        d[1] = 1;
        d[2] = 1; 

        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2]; // i자리 이친수는 (i-1 갯수 + 끝이 0) + (i-2 갯수 + 끝이 01)
        }

        System.out.println(d[n]);
        sc.close();
    }
}