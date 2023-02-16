import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] stack;
	static int pos=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		stack= new int[N];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()) {
			
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop":
				sb.append(pop()).append("\n");
				break;
				
			case "size":
				sb.append(size()).append("\n");
				break;
				
			case "empty":
				sb.append(empty()).append("\n");
				break;
				
			case "top":
				sb.append(top()).append("\n");
				break;
			}
		
		}
		System.out.print(sb);
		
	}
	
	static void push(int x) {
		stack[pos++]=x;
	}
	
	static int pop() {
		if(pos==0) return -1;
		else return stack[--pos];
	}
	
	static int size() {
		return pos;
	}
	
	static int empty() {
		if(pos==0) return 1;
		else return 0;
		
	}
	
	static int top() {
		if(pos==0) return -1;
		else return stack[pos-1];
		
	}
}
