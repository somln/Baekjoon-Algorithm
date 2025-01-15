import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();

		while(t-->0) {
			
			int n = in.nextInt();
			int[][] d = new int[41][2];
			
			d[0] = new int[] {1, 0};
			d[1] = new int[] {0, 1};
			d[2] = new int[] {1, 1};
			
			for(int i=3; i<=n; i++) {
				d[i] = new int[] {d[i-1][0]+ d[i-2][0], d[i-1][1] + d[i-2][1]};
			}
			
			System.out.println(d[n][0] +" "+d[n][1]);
		}
		
	}

}