import java.io.*;
import java.util.*;

public class Main {

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
		arr = new int[m];
		func(0, 0);  
		
		System.out.print(sb.toString());
	}

	public static void func(int k, int start) {  //start는 시작할 인덱스
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < n; i++) { {
				arr[k] = N[i];
				func(k + 1, i+1);
			}
		}
	}
}
