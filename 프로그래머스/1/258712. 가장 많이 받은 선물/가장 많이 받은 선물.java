import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
   
        int n = friends.length;
        
        Map<String, Integer> friendsIdx = new HashMap<>();
        for(int i = 0; i < n; i++){
            friendsIdx.put(friends[i], i);
        }
        
        int[][] giftCount = new int[n][n];
        int[] point = new int[n]; 
        
        for(String gift: gifts){
            String[] g = gift.split(" ");
            
            int giver = friendsIdx.get(g[0]);
            int receiver = friendsIdx.get(g[1]);
            
            giftCount[giver][receiver]++;
            point[giver]++;
            point[receiver]--;
        }
        
        int[] count = new int[n];
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(giftCount[i][j] > giftCount[j][i])
                    count[i]++;
                else if(giftCount[i][j] == giftCount[j][i]){
                    if(point[i] > point[j]) 
                        count[i]++;
                    else if(point[i] < point[j]) 
                        count[j]++;
                } else {
                    count[j]++;
                }
            }
        }
        
        return Arrays.stream(count).max().getAsInt();
    }
}
