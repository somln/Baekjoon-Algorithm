import java.util.*;
import java.io.*;

public class Main {

	static int arr[][];
	static int count[] = new int[2];
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(0,0,n);
		System.out.println(count[0]);
		System.out.println(count[1]);
		
	}
	
    //(r, c)부터 size 만큼 탐색
	public static void func(int r, int c, int size) {
		
		boolean check = true;
		//범위 내에 모든 수가 같은지 확인
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(arr[r][c]!=arr[i][j]) {
					check= false;
				}
			}
		}
		
        //모든 수가 같은 경우
		if(check) {
			count[arr[r][c]]++;
			return;
		}else {  //다른 수가 존재할 경우 size/2
			int n = size/2;
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					func(r+n*i, c+n*j, n);
				}
			}
		}
	}
}
