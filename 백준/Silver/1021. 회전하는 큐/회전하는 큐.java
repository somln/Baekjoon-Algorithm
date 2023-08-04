import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
        Scanner in = new Scanner(System.in);
		
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
		int count = 0;	
		
		int N = in.nextInt();	
		int M = in.nextInt();	
		
		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		 for (int i = 0; i < M; i++) {
			int key = in.nextInt();
			int index = deque.indexOf(key);
			
			if(index>deque.size()/2) {
				while(deque.getFirst()!=key) {
					deque.offerFirst(deque.pollLast());
					count++;
				}}			
			else
				while(deque.getFirst()!=key) {
					deque.offerLast(deque.pollFirst());
					count++;
			}
			deque.pollFirst();
		 }
		System.out.println(count);
	}
}