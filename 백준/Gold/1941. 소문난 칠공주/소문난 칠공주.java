import java.util.*;
import java.io.*;

public class Main {

    static int n = 5;
    static boolean[][] selected = new boolean[n][n];
    static char[][] board = new char[n][n];
    static int start;
    static int cnt = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        find(0, 0, 0);
        System.out.println(cnt);
    }

    public static void find(int depth, int selectedCnt, int sCnt) {

        // 7개를 선택한 경우
        if (selectedCnt == 7) {
            // S가 4개 이상인 경우에만 확인
            if (sCnt >= 4) {
                // 연결 여부 체크
                if (check()) {
                    cnt++;
                }
            }
            return;
        }

        // 선택할 칸을 순차적으로 시도
        for (int i = depth; i < n * n; i++) {
            selected[i / 5][i % 5] = true;
            if (selectedCnt == 0) {
                start = i;  // 첫번째 칸을 시작점으로 설정
            }
            // 선택한 칸이 'S'일 경우 sCnt 증가
            find(i + 1, selectedCnt + 1, sCnt + (board[i / 5][i % 5] == 'S' ? 1 : 0));
            selected[i / 5][i % 5] = false;
        }
    }

    public static boolean check() {
        boolean[][] visited = new boolean[n][n];
        int pCnt = 1;  // 방문한 칸의 개수
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{start / n, start % n});
        visited[start / n][start % n] = true;

        while (!qu.isEmpty()) {
            int[] q = qu.remove();
            int x = q[0];
            int y = q[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                // 선택된 칸이면서 아직 방문하지 않은 칸
                if (selected[nx][ny] && !visited[nx][ny]) {
                    qu.add(new int[]{nx, ny});
                    pCnt++;
                    visited[nx][ny] = true;
                }
            }
        }

        // 선택된 7개의 칸이 모두 연결되어 있어야 함
        return pCnt == 7;
    }
}
