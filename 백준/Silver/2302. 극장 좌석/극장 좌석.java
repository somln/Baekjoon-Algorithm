import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[42];
        long[] d = new long[42];
        
        for(int i=1; i<=m; i++) {
            a[sc.nextInt()] = 1;
        }
        
        // 초기값 설정
        d[0] = 1;  // 추가된 부분
        d[1] = 1;
        
        for(int i=2; i<=n; i++) {
            d[i] = d[i-1];  // 자리를 바꾸지 않는 경우
            if(a[i]!=1 && a[i-1]!=1) {  // 현재 위치와 이전 위치가 VIP석이 아닌 경우
                d[i] += d[i-2];  // 자리를 바꾸는 경우
            }
        }
        
        System.out.println(d[n]);
    }
}