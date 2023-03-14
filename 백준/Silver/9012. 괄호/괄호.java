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
			String result = "YES";
			
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				
				if(c=='(') {
					st.push(c);
				}
				else if(c==')') {
					if(!st.isEmpty()) st.pop();
					else result = "NO";				}
			}
			if(!st.isEmpty()) result = "NO";
			System.out.println(result);
			N--;
	}
  }
}
