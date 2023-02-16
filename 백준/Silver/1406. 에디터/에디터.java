import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> leftstack = new Stack<Character>();
		Stack<Character> rightstack = new Stack<Character>();
		
		String s = br.readLine();

		for(int i=0; i<s.length(); i++) {
			leftstack.push(s.charAt(i));
		}
		
		int N = Integer.parseInt(br.readLine());
			

        for(int i = 0; i <N; i++){
            String input = br.readLine();
            switch(input.charAt(0)){
                case 'L':
                    if(!leftstack.isEmpty()) rightstack.push(leftstack.pop());
                    break;
                case 'D':
                    if(!rightstack.isEmpty()) leftstack.push(rightstack.pop());
                    break;
                case 'B':
                    if(!leftstack.isEmpty()) leftstack.pop();
                    break;
                case 'P':
                    leftstack.push(input.charAt(2));
            }
        }
			
			while (!leftstack.isEmpty()) {
				rightstack.push(leftstack.pop());
			}
			
			StringBuilder sb = new StringBuilder();
			 
		    while(!rightstack.isEmpty()) {
		         sb.append(rightstack.pop());
		    }
		    
		    System.out.print(sb);
			
		}	
		
 }


