import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        Map<Character, Integer> result = new HashMap<>();
        
        result.put('R', 0);
        result.put('T', 0);
        result.put('C', 0);
        result.put('F', 0);
        result.put('J', 0);
        result.put('M', 0);
        result.put('A', 0);
        result.put('N', 0);
        
        for(int i=0; i<survey.length; i++){
            int c = choices[i];
            char lf = survey[i].charAt(0);
            char rt = survey[i].charAt(1);
            
            if(1 <= c && c <= 3) result.put(lf, result.get(lf)+ (4-c));
            else if(5 <= c && c <= 7) result.put(rt, result.get(rt)+ (c-4));
        }
        
        String answer = "";
        
        answer += result.get('R') >= result.get('T') ? "R" : "T";
        answer += result.get('C') >= result.get('F') ? "C" : "F";
        answer += result.get('J') >= result.get('M') ? "J" : "M";
        answer += result.get('A') >= result.get('N') ? "A" : "N";

        return answer;
    }
}