import java.util.Stack;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		while(n-->0) {
			
			String s = br.readLine();
			
			Stack<Character> lf = new Stack<>();
			Stack<Character> rt = new Stack<>();
			
			for(int i=0; i<s.length(); i++) {
				char x = s.charAt(i);
				switch(x) {
				case '<': if(!lf.isEmpty()) rt.push(lf.pop());
					break;
				case '>': if(!rt.isEmpty()) lf.push(rt.pop());
					break;
				case '-': if(!lf.isEmpty()) lf.pop();
					break; 
				default: lf.push(x);	
				}
			}
			
			while(!lf.isEmpty()) {
				rt.push(lf.pop());
			}
			
			StringBuilder sb = new StringBuilder();
		
			while(!rt.isEmpty()) {
				sb.append(rt.pop());
			}
			
			System.out.println(sb);
	    }
	}
}
