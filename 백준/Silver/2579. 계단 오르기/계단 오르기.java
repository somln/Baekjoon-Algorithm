import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] s = new int[n+1];
		int[][] d = new int[n+1][3]; // int[i][j] = i에 도착했을 때 j개의 계단을 연속해서 밟은 상태의 최댓값
		
		for (int i = 1; i <= n; i++) {
		    s[i] = in.nextInt();
		}
		
		if (n == 1) {
	       System.out.println(s[1]);
	       return;
	    }

		
		d[1][1] = s[1];
		d[1][2] = 0;
		d[2][1] = s[2];
		d[2][2] = s[1] + s[2];
		
		for(int i=3; i<=n; i++) {
			d[i][1] = Math.max(d[i-2][1], d[i-2][2]) + s[i];  
			d[i][2] = d[i-1][1] + s[i];
		}
		
		System.out.println(Math.max(d[n][1], d[n][2]));
	}
}
