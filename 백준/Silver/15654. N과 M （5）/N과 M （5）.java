import java.io.*;
import java.util.*;

public class Main {

	static boolean[] visited;
	static int[] arr;
	static int n;
	static int m;
	static int[] N;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		N = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			N[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(N);

		visited = new boolean[n];  
		arr = new int[m];
		func(0);
		
		System.out.print(sb.toString());
	}

	public static void func(int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
	
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				arr[k] = N[i];
				visited[i] = true;
				func(k + 1);
				visited[i] = false;
			}
		}
	}
}
