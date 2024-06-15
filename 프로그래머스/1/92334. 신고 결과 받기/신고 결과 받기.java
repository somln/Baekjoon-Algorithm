import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, HashSet<String>> record = new HashMap<>();
        Map<String, Integer> idx = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
            record.put(id_list[i], new HashSet<>());
            idx.put(id_list[i], i);
        }
        
        for (String s : report) {
            String[] split = s.split(" ");
            String reporter = split[0];
            String reported = split[1];
            
            record.get(reported).add(reporter);
        }
        
        int[] answer = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> hs = record.get(id_list[i]);
            if (hs.size() >= k) {
                for (String name : hs) {
                    answer[idx.get(name)]++;
                }
            }
        }
        
        return answer;
    }
}
