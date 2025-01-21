import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt();
			int[] a = new int[n];

			for(int i=0; i<n; i++) {
				a[i] =sc.nextInt();
			}

			int max = 0;
			long sum = 0;
			for(int i=n-1; i>=0; i--) {
				if(a[i]>=max) {
					max = a[i];
				}else {
					sum+=max-a[i];
				}
			}

			System.out.println(sum);
		}
		
	}

}
