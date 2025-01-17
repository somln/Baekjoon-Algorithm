import java.util.*;

public class Main {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int count =1;
		while(true) {
			int n = sc.nextInt();
			if(n==0) {
				break;
			}
			int[][] a = new int[100001][4];
			int[][] d = new int[n+1][4];
			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=3; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			
		      d[1][1] = 100001;
	          d[1][2] = a[1][2];       
	          d[1][3] = a[1][2] + a[1][3];
			
			
			for(int i=2; i<=n; i++) {
				d[i][1] = Math.min(d[i-1][1], d[i-1][2])+ a[i][1];
				d[i][2] = Math.min(d[i][1], Math.min(d[i-1][1], Math.min(d[i-1][2], d[i-1][3])))+ a[i][2];
				d[i][3] = Math.min(d[i][2], Math.min(d[i-1][2], d[i-1][3]))+ a[i][3];
			}
			
			
			System.out.println(count++ +". "+ d[n][2]);
			
		}
	
	}
}
