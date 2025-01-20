import java.util.*;

public class Main {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Integer[] s = new Integer[n];
        int[] a = new int[n+1];
        
        for(int i=0; i<n; i++) {
        	s[i] = sc.nextInt();
        }
        
        Arrays.sort(s);
        
        for(int i=1; i<=n; i++) {
        	a[i] = s[n-i]*i;  //i개의 로프를 사용할 때의 최댓값
        }
        
        int max = a[0];
        for(int i=1; i<=n; i++) {
        	max = Math.max(max, a[i]);
        }
        
        System.out.println(max);
	}

}
