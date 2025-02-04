import java.util.*;

public class Main {
    static final int MXN = 4000002;
    static boolean[] sieve = new boolean[MXN];
    static ArrayList<Integer> p = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < MXN; i++) {
            sieve[i] = true;
        }
        sieve[0] = sieve[1] = false; // 0과 1은 소수가 아님

        for (int i = 2; i * i < MXN; i++) {
            if (!sieve[i]) continue;
            for (int j = i * i; j < MXN; j += i) {
                sieve[j] = false;
            }
        }

        for (int i = 2; i < MXN; i++) {
            if (sieve[i]) {
                p.add(i);
            }
        }
        p.add(0); // 마지막에 0 추가

        int target = scanner.nextInt();
        int s = 0, e = 1, ans = 0;
        int sum = p.get(0);

        while (true) {
            if (sum == target) ans++;
            if (sum <= target) {
                sum += p.get(e++);
            }
            if (target < sum) {
                sum -= p.get(s++);
            }
            if (e == p.size()) break;
        }

        System.out.println(ans);
        scanner.close();
    }
}
