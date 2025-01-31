import java.util.*;

public class Main {
    static int N, M, x, y, d, ans;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        d = sc.nextInt();
        
        board = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        
        int chkCnt = 0;
        
        while (true) {
            // 청소하지 않은 빈 칸이면 청소
            if (board[x][y] == 0) ans++;
            board[x][y] = -1; // 청소한 칸 표시
            boolean cleaned = false;
            
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 왼쪽 회전
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (board[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    cleaned = true;
                    break;
                }
            }
            
            if (cleaned) continue;
            
            // 뒤쪽이 벽이면 종료
            if (board[x - dx[d]][y - dy[d]] == 1) break;
            
            // 후진
            x -= dx[d];
            y -= dy[d];
        }
        
        System.out.println(ans);
        sc.close();
    }
}