import java.util.*;

public class Main {
    static int n, k, l;
    static int[][] board = new int[105][105]; // 1: 뱀, 2: 사과
    static int[] dx = {1, 0, -1, 0};  // 아래, 오른쪽, 위, 왼쪽
    static int[] dy = {0, 1, 0, -1};
    static Deque<int[]> dq = new LinkedList<>();
    static Queue<int[]> switchDir = new LinkedList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            board[a][b] = 2; // 사과
        }
        
        l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            int c = sc.nextInt();
            char d = sc.next().charAt(0);
            switchDir.add(new int[]{c, d});
        }
        
        sc.close();
        System.out.println(playGame());
    }
    
    static int playGame() {
        int second = 0;
        int dir = 1;
        dq.addFirst(new int[]{1, 1});
        board[1][1] = 1; // 초기 뱀 위치 설정
        
        while (true) {
            dir %= 4;
            int[] cur = dq.peekFirst();
            second++;
            
            int nx = cur[0] + dx[dir];
            int ny = cur[1] + dy[dir];
            
            if (nx < 1 || nx > n || ny < 1 || ny > n || board[nx][ny] == 1) {
                break;
            }
            
            if (board[nx][ny] != 2) {
                int[] tail = dq.pollLast();
                board[tail[0]][tail[1]] = 0; // 꼬리 제거
            }
            
            board[nx][ny] = 1; // 뱀의 새로운 위치 표시
            dq.addFirst(new int[]{nx, ny});
            
            if (!switchDir.isEmpty() && switchDir.peek()[0] == second) {
                int[] sd = switchDir.poll();
                if (sd[1] == 'L') dir += 1;
                else if (sd[1] == 'D') dir += 3;
            }
        }
        
        return second;
    }
}
