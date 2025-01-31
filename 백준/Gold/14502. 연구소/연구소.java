import java.util.*;

public class Main {
	
	static int max = Integer.MIN_VALUE;
	static int n, m;
	static int[][] board = new int[9][9];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		buildWalls(0);
		System.out.println(max);
	}
	
	static void buildWalls(int depth) {
		if(depth == 3) {
			max = Math.max(max, bfs());
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if (board[i][j] == 0) { // 빈 공간에 벽 세우기
				    board[i][j] = 1;
				    buildWalls(depth + 1);
				    board[i][j] = 0; // 원상 복구
				}
			}
		}
	}
	
	static int bfs() {
		int dx[] = {0, 1, 0, -1};
		int dy[] = {1, 0, -1, 0};
		Queue<int[]> qu = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];

		// 바이러스 위치 저장
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j] == 2) {
					qu.offer(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		
		while(!qu.isEmpty()) {
			int[] q = qu.poll();
			int x = q[0];
			int y = q[1];
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				
				if(board[nx][ny] == 0 && !visited[nx][ny]) { // 빈 공간만 감염
					visited[nx][ny] = true;
					qu.offer(new int[] {nx, ny});
				}
			}
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j] == 0 && !visited[i][j]) cnt++;
			}
		}
		
		return cnt;
	}
}
