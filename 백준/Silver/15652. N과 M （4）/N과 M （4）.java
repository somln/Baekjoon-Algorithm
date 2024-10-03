import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static int n;
	static int m;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m];
		func(1, 0);
		
		System.out.print(sb.toString());
	}

	public static void func(int start, int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= n; i++) {
				arr[k] = i;
				func(i, k + 1);  //다음 arr[k+1]에 올 수 있는 수는 i부터 가능
			}
	
	}
}

