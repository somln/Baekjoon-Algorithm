import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int cnt = 0;
		while(N!=0) {
			
			String s = in.next();
			Stack<Character> st = new Stack<>();
			
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if((!st.isEmpty())&&(st.peek()==c)){
					st.pop();
				}
				else st.push(c);
			}
			if(st.isEmpty()) cnt++;
			N--;
		}
		System.out.println(cnt);
	}
}
