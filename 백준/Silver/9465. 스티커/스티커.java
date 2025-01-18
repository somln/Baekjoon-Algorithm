import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        
        while(t-->0) {
        	int n = sc.nextInt();
        	int[][] a = new int[3][n+1];
        	int[][] d = new int[3][n+1];
            //d[i][j]: i, j까지 계산했을 때의 최댓값
        	
        	for(int i=1; i<=2; i++) {
        		for(int j=1; j<=n; j++) {
        			a[i][j] = sc.nextInt();
        		}
        	}
        	
        	d[1][1] = a[1][1];
        	d[2][1] = a[2][1];
        	
        	for(int i=2; i<=n; i++) {
                //나를 포함시키지X 혹은 나를 포함시키고 이전 열의 다른 행까지의 최댓값 포함
        		d[1][i] = Math.max(d[1][i-1], d[2][i-1]+a[1][i]); 
        		d[2][i] = Math.max(d[2][i-1], d[1][i-1]+a[2][i]);
        	}
        	
        	System.out.println(Math.max(d[1][n], d[2][n]));
        }

    }
}