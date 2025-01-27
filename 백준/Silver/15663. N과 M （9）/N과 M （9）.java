import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int n;
	static int m;
	static int[] N;
	static boolean[] visited;
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
		arr = new int[m];
		visited = new boolean[n];
		
		func(0);
		System.out.println(sb);
	}
	public static void func(int k) {
		
		if(k==m) {
			for(int i=0; i<m; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append("\n");
			return;
		}
		
		int tmp = 0;
		for(int i=0; i<n; i++) {
			if(!visited[i] &&N[i]!=tmp) { //이전에 k번째 자리에 동일한 수가 왔었는지 확인
				arr[k] = N[i];
				visited[i] = true;
				tmp = N[i]; 
				func(k+1);
				visited[i] = false;
			}
			
		}
		
	}
	

}
