import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[10001];
		int[] d = new int[10001];
		
		for(int i=1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		
		d[1] = a[1];
		d[2] = a[1]+a[2];
		
		for(int i=3; i<=n; i++) {
			// 나를 포함 x: d[i-1]
			// 나를 포함: d[i-2]+a[i],  d[i-3]+a[i-1]+a[i]
			d[i] = Math.max(d[i-1], Math.max(d[i-2]+a[i], d[i-3] +a[i-1]+a[i]));
		}
		
		System.out.println(d[n]);
	}

}