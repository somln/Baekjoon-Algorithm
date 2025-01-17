import java.util.*;

public class Main {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] d = new long[1000001];
		
		d[0] = 0;
		d[1] =1;
		
		int k = Math.abs(n);
		
		for(int i=2; i<=k; i++) {
			d[i] = (d[i-1] + d[i-2]) % 1000000000;
		}
		
		if(n<0 && n%2==0) {
			System.out.println(-1);
		}
		else if(n==0) {
			System.out.println(0);
		}
		else {
			System.out.println(1);
		}

		System.out.println(d[k]);
	}

}
