import java.util.*;
import java.io.*;

public class Main {

	static int arr[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
		    String s = br.readLine(); 
		    for (int j = 0; j < n; j++) {
		        arr[i][j] = s.charAt(j) - '0'; 
		    }
		}
		
		func(0,0,n);
		System.out.println(sb);

		
	}
	
	public static void func(int r, int c, int size) {
		
		boolean check = true;
		
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(arr[r][c]!=arr[i][j]) {
					check= false;
				}
			}
		}
		
		if(check) {
			sb.append(arr[r][c]);
			return;
		}else {
			sb.append('(');
			int n = size/2;
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					func(r+n*i, c+n*j, n);
				}
			}
		}
		sb.append(')');
	}
}
