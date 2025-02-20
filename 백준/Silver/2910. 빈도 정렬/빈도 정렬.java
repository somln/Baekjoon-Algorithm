import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();
        
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freqMap.entrySet());

        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        for (Map.Entry<Integer, Integer> entry : list) {
            int count = entry.getValue();
            while (count-- > 0) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}