import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        while(n>0) {
        int l = Integer.parseInt(br.readLine());
        int[][] board = new int[l][l];
        Queue<Pair> qu = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int key_x = Integer.parseInt(st.nextToken());
        int key_y = Integer.parseInt(st.nextToken());

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                board[i][j] = -1;
            }
        }

        board[x][y] = 0;

        qu.offer(new Pair(x, y));

        while (!qu.isEmpty()) { 
            Pair p = qu.poll();
            
            if(p.x==key_x&&p.y==key_y) break;

            for (int k = 0; k < 8; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx < 0 || nx >= l || ny < 0 || ny >= l) continue;

                if (board[nx][ny] > -1) continue;

                board[nx][ny] = board[p.x][p.y] + 1;
                qu.offer(new Pair(nx, ny));

                if (nx == key_x && ny == key_y) break;
            }
        }
        System.out.println(board[key_x][key_y]);
        n--;

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