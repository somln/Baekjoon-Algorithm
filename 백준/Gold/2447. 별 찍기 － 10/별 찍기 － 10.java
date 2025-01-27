import java.util.*;
import java.io.*;

public class Main {
	
	static char[][] board;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		 board = new char[n][n];
		 for(int i=0; i<n; i++) {
			 Arrays.fill(board[i], ' ');
		 }
		 
		 func(0,0,n);
		 
		 StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                sb.append(board[i][j]);
	            }
	            sb.append('\n');
	        }

	     System.out.print(sb);
		 
		 
	}
	
	public static void func(int x, int y, int n) {
		 if (n == 1) {
	            board[x][y] = '*';
	            return;
	            }
		 
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i==1&&j==1) continue;  // 가운데는 비워두기
				int size = n / 3;
				func(x + size * i, y + size * j, size);
			}
		}
	}

}
