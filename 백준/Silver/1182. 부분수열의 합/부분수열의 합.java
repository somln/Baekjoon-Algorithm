import java.io.*;
import java.util.*;

public class Main {
	
	static int[] arr;
	static int n;
	static int s;
	static int cnt = 0;
	static int sum = 0;

	public static void main(String arg[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0, 0);
		if(s==0) {
			System.out.println(cnt-1);  //공집합 제외
		}
		else {
			System.out.println(cnt);
		}
		
	}
	
	//cur은 현재 시점
	public static void func(int cur, int sum) {
	    if (cur == n) { // 모든 원소를 다 고려한 경우
	        if (sum == s) cnt++; // 현재 부분 수열의 합이 목표 합과 같은 경우 cnt 증가
	        return;
	    }
	    func(cur + 1, sum); // 현재 원소를 선택하지 않는 경우
	    func(cur + 1, sum + arr[cur]); // 현재 원소를 선택하는 경우
	}
}
