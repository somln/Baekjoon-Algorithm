import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[] used1 = new boolean[40];   //해당 열이 점유되었는지
	static boolean[] used2 = new boolean[40];   //좌측 하단 대각선이 점유되었는지
	static boolean[] used3 = new boolean[40];   //우측 상단 대각선이 점유되엇는지
	static int n;
	static int cnt = 0;
	
	public static void main(String agrs[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		func(0);
		System.out.println(cnt);
	}
	
	//해당 행(cur)에 퀸을 놓을 자리를 찾는 함수
	public static void func(int cur) {
		if(cur == n) {
			cnt++;
			return;
		}
		//i는 열
		for(int i=0; i<n; i++) {
			if(used1[i] || used2[i+cur] || used3[cur-i+n-1]) {  //셋 중 어느 하나라도 점유되었으면 continue
				continue;
			}
			used1[i] = true;
			used2[i+cur] = true;
			used3[cur-i+n-1] = true;
			func(cur+1);  // 그 다음 행의 퀸을 계산
			used1[i] = false;
			used2[i+cur] = false;
			used3[cur-i+n-1] = false;
		}
	}

}
