

import java.util.LinkedList;
import java.util.Scanner;
 
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<Integer>();
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        int ans = 0;
        int num = 0;
        for (int i = 0; i < M; i++) {
            num = sc.nextInt();
            while (num != list.get(0)) {
                if (list.indexOf(num) <= list.size() / 2) {
                    int first = list.getFirst();
                    list.removeFirst();
                    list.addLast(first);
                } else {
                    int last = list.getLast();
                    list.removeLast();
                    list.addFirst(last);
                }
                ans++;
            }
            list.removeFirst();
        }
        System.out.println(ans);
    }
 
}
 