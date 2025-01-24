import java.util.*;

public class Main {
    static char[][] board;
    static boolean[][] vis;
    static int n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new char[n][n];
        vis = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String row = sc.next();
            board[i] = row.toCharArray();
        }

        int notG = area(); // 적록색약이 아닌 사람의 구역 수

        // 방문 배열 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis[i], false);
        }

        // 적록색약은 초록(G)과 빨강(R)을 구분하지 못하므로 초록을 빨강으로 변경
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'G') {
                    board[i][j] = 'R';
                }
            }
        }

        int isG = area(); // 적록색약인 사람의 구역 수

        System.out.println(notG + " " + isG);
    }


    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        vis[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue; 
                if (vis[nx][ny] || board[x][y] != board[nx][ny]) continue; 
                vis[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    static int area() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }
        return count;
    }
}
