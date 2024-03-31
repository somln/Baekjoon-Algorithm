
import java.util.*;
import java.io.*;

public class Main {
	
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int m, n;
    static int[][] board;
    static int[][] check;
    
	
	public static void main(String args[]) throws IOException {
		
		Scanner in = new Scanner(System.in);
		
		Queue<Pair> queue = new ArrayDeque<>();

        m = in.nextInt();
        n = in.nextInt();

        board = new int[n][m];
        check = new int[n][m];


        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		board[i][j] = in.nextInt();
        		
                if (board[i][j] == 1) {
                    queue.add(new Pair(i, j));
        		}
        	}
        }
        
        while(!queue.isEmpty()) {
 
        	Pair p = queue.poll();
        	
        	for(int k=0; k<4; k++) {
        		
        		int nx = dx[k] + p.x;
        		int ny = dy[k] + p.y;
        		
        		if(nx>=0 && ny>=0 && nx<n && ny<m && board[nx][ny]==0 && check[nx][ny]==0) {
        			queue.add(new Pair(nx, ny));
        			check[nx][ny]=check[p.x][p.y]+1;
        		}
        	}
        }
        
        for(int i = 0; i<n; i++) {
        	for(int j = 0; j< m; j++) {
        		if(board[i][j]==0 && check[i][j]==0) {
        			System.out.println(-1);
        	 	    return;
        		}
        	}
        }
        
        int max = -1;
        
        for(int i = 0; i<n; i++) {
        	for(int j = 0; j< m; j++) {
        		if(check[i][j]>max){
        			max = check[i][j];
        		}
        	}
        }
        System.out.println(max);   
	}
	
	static class Pair{
		
		int x;
		int y;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
