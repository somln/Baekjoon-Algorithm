import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] s = new int[n][2]; 

        for (int i = 0; i < n; i++) {
            s[i][0] = sc.nextInt(); // 시작 시간
            s[i][1] = sc.nextInt(); // 끝 시간
        }

        // 종료 시간 기준으로 정렬, 같으면 시작 시간 기준으로 정렬
        Arrays.sort(s, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]); // 시작 시간 비교
            } else {
                return Integer.compare(o1[1], o2[1]); // 종료 시간 비교
            }
        });

        int ans = 0; // 선택된 회의 수
        int t = 0;   // 현재 시간

        for (int i = 0; i < n; i++) {
            if (s[i][0] < t) continue; // 시작 시간이 현재 시간보다 이전이면 무시
            ans++; // 회의를 선택
            t = s[i][1]; // 현재 시간을 회의의 끝나는 시간으로 갱신
        }

        System.out.println(ans); 
        sc.close();
    }
}
