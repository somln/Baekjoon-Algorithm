import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            Queue<Pair> qu = new LinkedList<>();

            int[][] board = new int[n][m];
            int[][] visited = new int[n][m];
            int count = 0;

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                board[x][y] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (board[i][j] == 0 || visited[i][j] == 1) {
                        continue;
                    }

                    count++;
                    visited[i][j] = 1;
                    qu.offer(new Pair(i, j));

                    while (!qu.isEmpty()) {
                        Pair p = qu.poll();

                        for (int f = 0; f < 4; f++) {
                            int nx = p.x + dx[f];
                            int ny = p.y + dy[f];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                                continue;
                            }

                            if (board[nx][ny] == 0 || visited[nx][ny] == 1) {
                                continue;
                            }
                            qu.offer(new Pair(nx, ny));
                            visited[nx][ny] = 1;
                        }
                    }
                }
            }

            System.out.println(count);
        }
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

