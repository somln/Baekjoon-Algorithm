import java.util.*;

class Solution {
    
    static String answer = "";
    static Map<Character, int[]> keypad = new HashMap<>();
    static char left = '*';
    static char right = '#';
    public String solution(int[] numbers, String hand) {

        keypad.put('1', new int[]{0, 0});
        keypad.put('2', new int[]{0, 1});
        keypad.put('3', new int[]{0, 2});
        keypad.put('4', new int[]{1, 0});
        keypad.put('5', new int[]{1, 1});
        keypad.put('6', new int[]{1, 2});
        keypad.put('7', new int[]{2, 0});
        keypad.put('8', new int[]{2, 1});
        keypad.put('9', new int[]{2, 2});
        keypad.put('*', new int[]{3, 0});
        keypad.put('0', new int[]{3, 1});
        keypad.put('#', new int[]{3, 2});

        
        for(int i =0; i<numbers.length; i++){
            char number = (char) (numbers[i] + '0');
            if(number=='1'||number=='4'||number=='7'){
                left(number);
            }
            else if(number=='3'||number=='6'||number=='9'){
                right(number);
            }
            else{
                int lf[] = keypad.get(left);
                int rt[] = keypad.get(right);
                int num[] = keypad.get(number);
                
                int lf_dis = Math.abs(lf[0]-num[0]) + Math.abs(lf[1]-num[1]);
                int rt_dis = Math.abs(rt[0]-num[0]) + Math.abs(rt[1]-num[1]);
                
                if(lf_dis<rt_dis){
                    left(number);
                }
                else if(lf_dis>rt_dis){
                    right(number);
                }
                else{
                    if(hand.equals("left")){
                        left(number);
                    }
                    else{
                        right(number);
                    }
                }
            }
        }
        
        return answer;
    }
    
    public void left(char number){
        answer +='L';
        left = number;
    }
    public void right(char number){
        answer +='R';
        right = number;
    }
}