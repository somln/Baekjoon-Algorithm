import java.util.*;
import java.io.*;

public class Main {
	
	static int[] arr = new int[6];
	static int[] N;
	static StringBuilder sb = new StringBuilder();
	static int n;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			if(n==0) {
				break;
			}
			
			N = new int[n];
			for(int i=0; i<n; i++) {
				N[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(N);
			func(0, 0);
			sb.append("\n");
			
		}
		System.out.println(sb);

	}
	
	public static void func(int start, int k) {	
		if(k==6) {
			for(int i=0; i<6; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		 for (int i = start; i < n; i++) {
	            arr[k] = N[i];
	            func(i + 1, k + 1); 
	        }
	}
}
