import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        
        String[] todaySplit = today.split("\\.");
        int tYear = Integer.parseInt(todaySplit[0]);
        int tMonth = Integer.parseInt(todaySplit[1]);
        int tDay = Integer.parseInt(todaySplit[2]);
        
        Map<String, Integer> termsMap = new HashMap<>();
        
        for (String term : terms) {
            String[] s = term.split(" ");
            termsMap.put(s[0], Integer.parseInt(s[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            String[] dateSplit = s[0].split("\\.");
            
            int year = Integer.parseInt(dateSplit[0]);
            int month = Integer.parseInt(dateSplit[1]) + termsMap.get(s[1]);
            int day = Integer.parseInt(dateSplit[2]);
            
            while (month > 12) {
                year ++;
                month -=12;
            }
            
            if ((tYear > year) || 
                (tYear == year && tMonth > month) || 
                (tYear == year && tMonth == month && tDay >= day)) {
                answerList.add(i + 1);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
