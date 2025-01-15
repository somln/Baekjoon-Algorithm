import java.util.Scanner;

public class Main {

	public static void main(String args[]){
		
		 Scanner sc = new Scanner(System.in);
	        
	        int n = sc.nextInt();
	        int[][] a = new int[n + 1][n + 1]; 
	        int[][] d = new int[n + 1][n + 1]; 
	        

	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= i; j++) {
	                a[i][j] = sc.nextInt();
	            }
	        }


	        d[1][1] = a[1][1];


	        for (int i = 2; i <= n; i++) {
	            for (int j = 1; j <= i; j++) {
	                d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + a[i][j];
	                //내 대각선 오른쪽, 왼쪽 위 중 더 큰 값
	            }
	        }

	        // 맨 마지막 줄에서 가장 큰 수 
	        int maxPath = 0;
	        for (int i = 1; i <= n; i++) {
	            maxPath = Math.max(maxPath, d[n][i]);
	        }

	        System.out.println(maxPath);

	    }
}
