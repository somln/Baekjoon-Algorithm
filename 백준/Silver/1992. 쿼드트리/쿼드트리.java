import java.util.*;

public class Main {

    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine(); // 개행 문자 제거
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        func(0, 0, n);
        System.out.println(sb.toString());
    }

    public static void func(int r, int c, int n) {
        if (check(r, c, n)) {
            sb.append(arr[r][c]);
        } else {
            sb.append('(');
            int size = n / 2;
            func(r, c, size);
            func(r, c + size, size);
            func(r + size, c, size);
            func(r + size, c + size, size);
            sb.append(')');
        }
    }

    public static boolean check(int r, int c, int n) {
        int value = arr[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
