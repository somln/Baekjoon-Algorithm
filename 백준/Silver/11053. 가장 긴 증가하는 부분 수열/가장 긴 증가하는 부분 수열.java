import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a[] = new int[n+1];
		int d[] = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			a[i] = sc.nextInt();
			d[i] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=1; j<i; j++) {
				if(a[j] < a[i] && d[j]+1>d[i]) {
					d[i] = d[j] +1;
				}
			}
		}
		
		int max = 0;
		for(int i=1; i<=n; i++) {
			max = (Math.max(max, d[i]));
		}
		System.out.println(max);
		
	}
}