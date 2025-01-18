import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        boolean[] dp = new boolean[1001];

        dp[1] = true; // SK 승리
        dp[2] = false; // CY 승리
        dp[3] = true; // SK 승리
        dp[4] = true; // SK 승리

        for (int i = 5; i <= N; i++) {
            //세 경우 중 하나라도 CY가 지는 상태이면 SK는 이김
            dp[i] = !(dp[i - 1] && dp[i - 3] && dp[i - 4]);
        }

        if (dp[N]) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
