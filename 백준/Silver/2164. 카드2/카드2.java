import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	
		Queue<Integer> queue = new LinkedList<Integer>();
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		while(queue.size()!=1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		System.out.println(queue.peek());
    }
}
