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
		
		System.out.print(sb.toString());
	}

   //func(k)는 현재 k개위치까지 수를 택한 상황에서 arr[k]를 정하는 함수
	public static void func(int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// k는 숫자 위치, i는 숫자		
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				arr[k] = i;
				visited[i] = true;
				func(k + 1);
				visited[i] = false;
			}
		}
	}
}

