import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 트럭 개수
        int w = sc.nextInt(); // 다리 길이
        int l = sc.nextInt(); // 다리 최대 하중

        Queue<Integer> truck = new LinkedList<>();
        Queue<int[]> qu = new LinkedList<>(); // {트럭 무게, 다리에서의 위치}

        for (int i = 0; i < n; i++) {
            truck.add(sc.nextInt());
        }

        int total = 0; 
        int current = 0;

        while (!truck.isEmpty() || !qu.isEmpty()) {
            current++; // 시간 증가

            // 다리를 빠져나간 트럭 제거
            if (!qu.isEmpty() && qu.peek()[1] + w == current) {
                total -= qu.poll()[0];
            }

            // 새로운 트럭이 다리에 올라갈 수 있는지 확인
            if (!truck.isEmpty() && total + truck.peek() <= l && qu.size() < w) {
                int t = truck.poll();
                total += t;
                qu.add(new int[]{t, current});
            }
        }

        System.out.println(current);
        sc.close();
    }
}
