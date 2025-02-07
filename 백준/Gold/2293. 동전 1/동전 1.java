import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
	    int[] arr = new int[n];  // 동전 리스트
	    int[] dp = new int[k + 1]; // dp[j]: j원을 만드는 방법의 수

	    for (int i = 0; i < n; i++) {
	    	arr[i] = Integer.parseInt(br.readLine());
	    	}
	    
	    dp[0] = 1; //0을 만드는 법은 1개
	    
	    // 각 동전별로 dp 배열을 업데이트
	    for(int a : arr) {
	    	for(int i=a; i<=k; i++) {
	    		dp[i] += dp[i-a];
	    	}
	    }
	    System.out.println(dp[k]);
	}

}
