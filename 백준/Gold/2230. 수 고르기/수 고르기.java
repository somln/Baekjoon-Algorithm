import java.util.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);

		int en=0;
		int min = Integer.MAX_VALUE;
		
		for(int st=0; st<n; st++) {
			// arr[en] - arr[st] >= m이 될 때까지 en을 계속 증가시킴
			while(en<n && arr[en]-arr[st]<m) en++;
			//만족하는 값이 없어서 en==n까지 왔을 경우 break
			if(en==n) break;
			min = Math.min(min, arr[en]-arr[st]);
		}
		
		System.out.println(min);
		
	}
}
