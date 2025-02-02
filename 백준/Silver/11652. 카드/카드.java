import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        HashMap<Long, Integer> card = new HashMap<>();
        int max = 0;
        long key = 0;

        for (int i = 0; i < n; i++) {
            long k = sc.nextLong(); 

            card.put(k, card.getOrDefault(k, 0) + 1);

            if (card.get(k) > max) {
                max = card.get(k);
                key = k;
            } else if (card.get(k) == max) {
                key = Math.min(k, key);
            }
        }
        
        System.out.println(key);
        sc.close();
    }
}
