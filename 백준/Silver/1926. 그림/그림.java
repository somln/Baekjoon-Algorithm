import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

	
	static int[][]board;
	static boolean[][] visited;
	static int n, m;
	static int count=0;
	static int maxSize=0;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		board = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				board[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				if(board[i][j]==1&&!visited[i][j]) {
					count++;
					bfs(i,j);
				}
			}
		}
		System.out.println(count);
		System.out.println(maxSize);
		
	}


	private static void bfs(int i, int j) {
         
		Queue<Pair> list = new LinkedList<>();
         
         int nx;
         int ny;
         int area=0;
        
         visited[i][j]=true;
         list.add(new Pair(i,j));
         
         while(!list.isEmpty()) {
        	 Pair pair =  list.remove();
        	 area++;
        	 
        	 for(int k=0; k<4; k++) {
        		 
        		 nx = pair.x + dx[k];
        		 ny = pair.y + dy[k];
        		 
        		 if(nx<0 || ny<0 || nx>=n || ny>=m ) continue;
        		 
        		 if(!visited[nx][ny] && board[nx][ny]==1) {
        	
        			 visited[nx][ny]= true;
        			 list.add(new Pair(nx, ny));
        			 
        		 }
        		 	 
        	 }
         }
        
		if(area>maxSize) maxSize=area;
		
	}
	
	static class Pair{
		int x;
		int y;
		
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}
