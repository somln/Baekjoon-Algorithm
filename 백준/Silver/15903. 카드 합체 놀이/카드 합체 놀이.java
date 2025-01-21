import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] a = new long[n];  
        
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        
        while(m-->0) {
            Arrays.sort(a);
            long sum = a[0] + a[1];  
            a[0] = sum;
            a[1] = sum;
        }
        
        long result = 0;  
        for(int i=0; i<n; i++) {
            result += a[i];
        }
        
        System.out.println(result);
        sc.close();
    }
}