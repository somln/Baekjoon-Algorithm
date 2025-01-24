import java.util.*;
import java.io.*;

public class Main {
	
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] board;
    static int[][][] dist;
    static int m, n, h;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		int h = sc.nextInt();
		
		board = new int[n][m][h];
	    dist = new int[n][m][h];
		Queue<Pair> qu = new LinkedList<>();
        
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    int tmp = sc.nextInt();
                    board[y][x][z] = tmp;
                    if (tmp == 1) qu.offer(new Pair(y, x, z)); // 익은 토마토 추가
                    if (tmp == 0) dist[y][x][z] = -1; // 익지 않은 토마토는 거리 -1
                }
            }
        }
        
        while(!qu.isEmpty()) {
        	Pair p = qu.poll();
        	
        	for(int k=0; k<6; k++) {
        		int nx = p.x+dx[k];
        		int ny = p.y+dy[k];
        		int nz = p.z+dz[k];
        		
        		 if (ny < 0 || ny >= n || nx < 0 || nx >= m || nz < 0 || nz >= h) continue;
                 if (dist[ny][nx][nz] >= 0) continue; // 이미 방문한 곳
                 
                 dist[ny][nx][nz] = dist[p.y][p.x][p.z]+1;
                 qu.offer(new Pair(ny, nx, nz));
        	}
        	
        }
        
        int ans = 0;
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                	if (dist[y][x][z] == -1) { // 익지 않은 토마토가 남아있다면
                        System.out.println(-1);
                        return;
                    }
                    ans = Math.max(ans, dist[y][x][z]); // 최댓값 갱신
                }
            }
        }
        
        System.out.println(ans);
       
	}
	
	
	static class Pair{
		int y;
		int x;
		int z;
		
		Pair(int y, int x, int z){
			this.y = y;
			this.x = x;
			this.z = z;
		}
	}
}
