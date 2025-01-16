import java.util.*;

public class Main {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	long[][] d = new long[n+1][10];
    	//d[i][j] = i번째 자리에서 j의 갯수 
    	
    	for(int i=1; i<=9; i++) {
    		d[1][i] = 1;
    	}
    	
    	for(int i=2; i<=n; i++) {
    		for(int j=0; j<=9; j++) {
    			//이전 자릿수에 나보다 1 작은 수의 갯수 + 나보다 1 큰 수의 갯수
    			if(j!=0) d[i][j] += d[i-1][j-1]; 
    			if(j!=9) d[i][j] += d[i-1][j+1];
    			d[i][j] %= 1000000000;
    		}
    	}
    	
        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += d[n][i];
            result %= 1000000000;
        }

        System.out.println(result);
    }
    
}
