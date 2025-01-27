import java.io.*;
import java.util.*;

public class Main {

	static boolean[] visited;
	static int[] arr;
	static int n;
	static int m;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];  //visited[n]까지 있어야 함
		arr = new int[m];
		func(0);
		
		System.out.print(sb);
	}

   //func(i)는 현재 i개위치까지 수를 택한 상황에서 arr[i]를 정하는 함수
	public static void func(int i) {
		if(i==m){
			for(int j=0; j<i; j++) {
				sb.append(arr[j]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int k=1; k<=n; k++) {
			if(!visited[k]) {
				arr[i] = k;
				visited[k] = true;
				func(i+1);
				visited[k] = false;
			}
		}
		
	}
}

