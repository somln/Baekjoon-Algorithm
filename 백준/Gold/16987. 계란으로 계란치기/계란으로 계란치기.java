import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] arr;
	static int n;
	static int cnt = 0;
	static int max = 0;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		func(0);
		System.out.println(max);
	}
	
	public static void func(int k) {
		if (k == n) { // 모든 계란을 처리했으면 최대값 갱신
			max = Math.max(max, cnt);
			return;
		}
		
		if (arr[k][0] <= 0 || cnt == n - 1) { 
			// k번째 계란이 이미 깨졌거나 다른 모든 계란이 깨졌으면 다음 계란으로 넘어감
			func(k + 1);
			return;
		}

		for (int i = 0; i < n; i++) { // i번째 계란을 내려치기
			if (i == k || arr[i][0] <= 0) continue;   // 자기 자신을 치거나 이미 깨진 계란은 제외
			
			// 계란 상태 변경
			arr[k][0] -= arr[i][1];
			arr[i][0] -= arr[k][1];
			
			if (arr[k][0] <= 0) cnt++;
			if (arr[i][0] <= 0) cnt++;
			
			// 다음 계란 처리
			func(k + 1);
			
			// 상태 복구
			if (arr[k][0] <= 0) cnt--;
			if (arr[i][0] <= 0) cnt--;
			
			arr[k][0] += arr[i][1];
			arr[i][0] += arr[k][1];
		}
	}
}
