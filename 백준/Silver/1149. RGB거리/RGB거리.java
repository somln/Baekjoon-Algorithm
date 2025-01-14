import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        int[][] rgb = new int[n][3];
        int[][] d = new int[n][3];
		//d[i][0] : i번째 집까지 칠했을 때 비용의 최솟값, 단 i번째집은 빨강
		//d[i][1] : i번째 집까지 칠했을 때 비용의 최솟값, 단 i번째집은 초록
		//d[i][2] : i번째 집까지 칠했을 때 비용의 최솟값, 단 i번째집은 파랑
        
        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(line[j]);
            }
        }

        if (n == 1) {
            System.out.println(Math.min(rgb[0][0], Math.min(rgb[0][1], rgb[0][2])));
            return;
        }

 
        d[0][0] = rgb[0][0];
        d[0][1] = rgb[0][1];
        d[0][2] = rgb[0][2];


        for (int i = 1; i < n; i++) {
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + rgb[i][0];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + rgb[i][1];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + rgb[i][2];
        }

    
        System.out.println(Math.min(d[n-1][0], Math.min(d[n-1][1], d[n-1][2])));
    }
}
