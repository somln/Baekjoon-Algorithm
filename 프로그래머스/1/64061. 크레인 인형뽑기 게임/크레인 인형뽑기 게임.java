import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for(int move : moves){
            for(int j=0; j<board.length; j++){
                int num = board[j][move-1];
                if(num !=0){
                    if(!stack.isEmpty()&&stack.peek()==num){
                        stack.pop();
                        answer+=2;
                    }
                    else{
                        stack.push(num);
                    }
                    board[j][move-1] = 0;
                  break;
                }
            }
        }
        return answer;
    }
}