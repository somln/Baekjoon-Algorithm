import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;



public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int m, n;
    static int[][] board;
    static int[][] check;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        m = in.nextInt();
        n = in.nextInt();

        board = new int[n][m];
        check = new int[n][m];

        Queue<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = in.nextInt();
                board[i][j] = x;
                if (x == 1) {
                    queue.add(new Pair(i, j));
                    check[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0 && check[nx][ny] == 0) {
                    check[nx][ny] = check[p.x][p.y] + 1;
                    queue.add(new Pair(nx, ny));
                }
            }
        }

        int max = Arrays.stream(check)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElse(-1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && check[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(max);
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


