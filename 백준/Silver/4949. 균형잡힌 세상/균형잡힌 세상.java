import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			String s = in.nextLine();
			if(s.equals(".")) break;
			Stack<Character> st = new Stack<>();
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				
				if((c=='[') || (c=='(')) {
					st.push(c);
				}
				else if(c==']') {
					if(!st.isEmpty()&&st.peek()=='[') st.pop();
					else st.push(c);
				}
				else if(c==')') {
					if(!st.isEmpty()&&st.peek()=='(') st.pop();
					else st.push(c);
				}
			}
			
			if(st.isEmpty()) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
