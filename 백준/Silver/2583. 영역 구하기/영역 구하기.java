import java.util.*;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static boolean[][] vis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();

        board = new int[m][n];
        vis = new boolean[m][n];

        while (k-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    board[i][j] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 || vis[i][j]) {
                    continue;
                }

                count++;
                int area = bfs(i, j, m, n);
                areas.add(area);
            }
        }

        Collections.sort(areas);
        System.out.println(count);
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }

    static int bfs(int x, int y, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        vis[x][y] = true;

        int area = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (board[nx][ny] == 1 || vis[nx][ny]) {
                    continue;
                }

                queue.add(new int[]{nx, ny});
                vis[nx][ny] = true;
                area++;
            }
        }

        return area;
    }
}
