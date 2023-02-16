import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		Stack<Integer> stack= new Stack<Integer>();
		
		int N = in.nextInt();
		int x;
		int sum=0;
		
		for(int i=0; i<N; i++) {
			x=in.nextInt();
			if(x!=0) {
				stack.push(x);
			}
			else stack.pop();
		}
		
		for(int s:stack) {
			sum+=s;
		}
		System.out.println(sum);
		
	}
}