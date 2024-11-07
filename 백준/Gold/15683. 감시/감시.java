import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[] dx = {1, 0, -1, 0}; // 0: 동쪽, 1:북쪽, 2: 서쪽, 3:남쪽 
    static int[] dy = {0, 1, 0, -1}; 
    static int n, m;
    static int[][] board1 = new int[10][10]; // 최초 입력받은 board 저장용
    static int[][] board2 = new int[10][10]; // 사각 지대 개수를 계산할 때 사용할 board
    static List<int[]> cctv = new ArrayList<>(); // CCTV 좌표 저장용 리스트

    // Out Of Bounds 확인 메서드
    static boolean OOB(int a, int b) {
        return a < 0 || a >= n || b < 0 || b >= m;
    }

    // (x,y)에서 dir 방향으로 진행하면서 벽을 만날 때까지 모든 빈 칸을 7로 바꾸는 메서드
    static void upd(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (OOB(x, y) || board2[x][y] == 6) return; // 범위를 벗어나거나 벽을 만나면 종료
            if (board2[x][y] != 0) continue; // 해당 칸이 빈 칸이 아니면 넘어감
            board2[x][y] = 7; // 빈 칸을 7로 덮음
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int minBlindSpot = 0; // 최소 사각 지대 크기 (정답)
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board1[i][j] = sc.nextInt();
                if (board1[i][j] != 0 && board1[i][j] != 6)
                    cctv.add(new int[]{i, j}); // CCTV 좌표 저장
                if (board1[i][j] == 0) minBlindSpot++;
            }
        }

        int totalCases = 1 << (2 * cctv.size()); // 모든 경우의 수 4^(CCTV 개수)
        for (int tmp = 0; tmp < totalCases; tmp++) {
            for (int i = 0; i < n; i++)
                System.arraycopy(board1[i], 0, board2[i], 0, m); // board1 복사
            
            int brute = tmp;
            for (int i = 0; i < cctv.size(); i++) {
                int dir = brute % 4;     //dir: 동서남북 방향
                brute /= 4;
                int x = cctv.get(i)[0];
                int y = cctv.get(i)[1];
                
                if (board1[x][y] == 1) {
                    upd(x, y, dir);	//한 방향
                } else if (board1[x][y] == 2 ) {
                    upd(x, y, dir);       
                    upd(x, y, dir + 2);   //위 방향과 반대 방향
                } else if (board1[x][y] == 3) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);  //위 방향과 직각인 방향
                } else if (board1[x][y] == 4) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                } else { // board1[x][y] == 5, 모든 방향
                    upd(x, y, dir);       
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                    upd(x, y, dir + 3);
                }
            }

            int currentBlindSpot = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (board2[i][j] == 0) currentBlindSpot++;
            minBlindSpot = Math.min(minBlindSpot, currentBlindSpot);
        }

        System.out.println(minBlindSpot);
    }
}
