import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] board;
	static int[][] visited;
	static int n,m;
	
	public static void main(String ars[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			int cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			board = new int[n][m];
			visited = new int[n][m];
			
			for(int i = 0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				board[x][y] = 1;
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if((board[i][j]==1)&&(visited[i][j]==0)) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}	
	}
	
	public static void bfs(int i, int j) {
		
		Queue<Pair> list = new LinkedList<>();

		visited[i][j]=1;
		list.add(new Pair(i, j));
		
		while(!list.isEmpty()) {
			Pair p = list.remove();
			
			for(int k =0; k<4; k++) {
				int nx =  p.x + dx[k];
				int ny = p.y+ dy[k];
				
				if(nx<0 ||  ny<0 || nx>=n || ny>=m) continue;
				
				if(board[nx][ny]==1 && visited[nx][ny]==0) {
					visited[nx][ny] = 1; 
					list.add(new Pair(nx, ny));
				}
			}
		}
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
