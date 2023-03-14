import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
			
		String s = in.next();
		Stack<Character> st = new Stack<>();
		char bf=s.charAt(0);
		int cnt = 0;
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c=='(') {
				st.push(c);
			}
			else if(c==')') {
				if(!st.isEmpty() && bf=='(') {
					st.pop();
					cnt+=st.size();
					}
				else if (!st.isEmpty() && bf!='('){
					st.pop();
					cnt++;
				}
		}
			bf =c;
      }
		System.out.println(cnt);
  }
}
