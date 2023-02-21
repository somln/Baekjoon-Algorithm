import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		int N = in.nextInt();
		int K = in.nextInt();
		
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		while(queue.size()!=0) {
			for(int i=1; i<K; i++) {
				queue.offer(queue.poll());
			}
			if(queue.size()==1) sb.append(queue.poll());
			else sb.append(queue.poll()+ ", ");
		}
		sb.append(">");
		
		System.out.println(sb);
    }
}
