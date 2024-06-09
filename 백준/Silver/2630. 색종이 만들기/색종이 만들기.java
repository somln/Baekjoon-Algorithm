import java.io.*;
import java.util.*;

public class Main {

	static int[][] arr;
	static int[] count = new int[2];
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j]=in.nextInt();
			}
		}
		
		func(0,0,n);
		System.out.println(count[0]);
		System.out.println(count[1]);
	}
	
	public static void func(int r, int c, int size) {
		if(check(r, c, size)) {
			count[arr[r][c]]++;
			return;
		}
		int n = size/2;
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				func(r+n*i, c+n*j, n);
			}
		}	
	}
	
	public static boolean check(int r, int c, int size) {
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(arr[r][c]!=arr[i][j])
					return false;
			}
		}
		return true;
	}
}
