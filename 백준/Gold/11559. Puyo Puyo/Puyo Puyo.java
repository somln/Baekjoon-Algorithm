import java.util.*;

public class Main {
	
	static char[][] board = new char[12][6];
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int total = 0;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		for(int i=0; i<12; i++) {
			board[i] = sc.next().toCharArray();
		}

		while (true) {
			visited = new boolean[12][6]; 
			boolean isPopped = false; 
	        
			// 4개 이상 연결된 뿌요 찾기
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (board[i][j] != '.' && !visited[i][j]) {
						if (bfs(i, j)) {
							isPopped = true;
						}
					}
				}
			}
	        
			// 터진 뿌요가 있으면 연쇄 증가 후 뿌요 아래로 떨어뜨리기
			if (isPopped) {
				total++;
				drop();
			} else {
				break;
			}
		}
		System.out.println(total);
		sc.close();
	}

	public static boolean bfs(int i, int j) {
		Queue<int[]> qu = new LinkedList<>();
		ArrayList<int[]> arr = new ArrayList<>();
		
		qu.add(new int[] {i, j});
		arr.add(new int[] {i, j});
		visited[i][j] = true;
		
		while (!qu.isEmpty()) {
			int[] q = qu.poll();
			char pr = board[q[0]][q[1]];
			
			for (int k = 0; k < 4; k++) {
				int nx = q[0] + dx[k];
				int ny = q[1] + dy[k];
				
				if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
				if (board[nx][ny] == pr && !visited[nx][ny]) {
					qu.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					arr.add(new int[] {nx, ny});
				}
			}
		}
		
		//연속된 뿌요가 4개 이상일 경우 터짐 
		if (arr.size() >= 4) {
			for (int[] temp : arr) {
				board[temp[0]][temp[1]] = '.';
			}
			return true;
		}
		return false;
	}

	public static void drop() {
	    for (int j = 0; j < 6; j++) {
	        int emptyRow = 11; // .이 저장되어있는 가장 아래 행
	        for (int i = 11; i >= 0; i--) {
	            if (board[i][j] != '.') {
	                char tmp = board[i][j];
	                board[i][j] = '.';
	                board[emptyRow][j] = tmp;
	                emptyRow--;
	            }
	        }
	    }
	}
}
