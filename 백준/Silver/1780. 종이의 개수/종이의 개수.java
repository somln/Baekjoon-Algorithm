import java.util.*;
import java.io.*;

public class Main {

	static int arr[][];
	static int count[] = new int[3]; //-1,0,1 개수 카운트
	
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
		System.out.println(count[2]);
		
	}
	
	public static void func(int r, int c, int size) {
		
		if(check(r, c, size)) {
			count[arr[r][c]+1]+=1;
			return;
		}
		
		//같은 수로 채워지지 않은 경우에는 9등분해서 다시 확인
		int n = size/3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				func(r+n*i, c+n*j, n);
			}
		}
	}
	
	//해당 종이 내부가 같은 수로 채워졌는지 확인
	public static boolean check(int r, int c, int size) {
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(arr[r][c]!=arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
