import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Pair> qu = new LinkedList<>();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        char[][] map = new char[n][n];
        int[][] visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
                visited[i][j] = 0; 
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (map[i][j] == '1' && visited[i][j] == 0) {

                    visited[i][j] = 1;
                    qu.offer(new Pair(i, j));
                    count++;

                    while (!qu.isEmpty()) {

                        Pair p = qu.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                            if (map[nx][ny] == '0' || visited[nx][ny] != 0) continue;

                            qu.offer(new Pair(nx, ny));
                            visited[nx][ny] = 1;
                            count++;
                        }
                    }
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        
        for(int x:list) {
        	System.out.println(x);
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
