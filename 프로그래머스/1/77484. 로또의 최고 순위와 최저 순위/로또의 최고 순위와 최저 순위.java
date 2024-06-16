class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int zero = 0, count = 0;
        
        for(int i : lottos){
            if(i == 0) zero++;
        }
        
        for(int i = 0; i < lottos.length; i++){
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]) count++;
            }
        }
        
        int answer[] = {Math.min(6, 7-(count+zero)), Math.min(6, 7-(count))};
        return answer;
    }
}