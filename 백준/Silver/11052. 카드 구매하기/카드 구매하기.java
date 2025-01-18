import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int[] d = new int[n + 1];


        for (int i = 1; i <= n; i++) {
            d[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                d[i] = Math.max(d[i - j] + d[j], d[i]);
            }
        }

        System.out.println(d[n]);
        sc.close();
    }
}
