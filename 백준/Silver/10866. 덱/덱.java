import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dat;
	static int head, tail;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		dat = new int[N];
		head = N/2;
		tail = N/2;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()) {
			case "push_front":
				push_front(Integer.parseInt(st.nextToken()));
				break;
			
			case "push_back":
				push_back(Integer.parseInt(st.nextToken()));
				break;
			
			case "pop_front":
				sb.append(pop_front()+"\n");
				break;
			
			case "pop_back":
				sb.append(pop_back()+"\n");
				break;
				
			case "size":
				sb.append(size()+"\n");
				break;
				
			case "empty":
				sb.append(empty()+"\n");
				break;
				
			case "front":
				sb.append(front()+"\n");
				break;
				
			case "back":
				sb.append(back()+"\n");
				break;
	
			}
		}
		
		System.out.println(sb);
	}

	
	static void push_front(int x) {
		dat[--head]=x;
	}
	
	static void push_back(int x) {
		dat[tail++]=x;
	}
	
	static int pop_front() {
		if(tail-head==0) return -1;
		else return dat[head++];
	}
	
	static int pop_back() {
		if(tail-head==0) return -1;
		else return dat[--tail];
	}
	
	static int size() {
		return tail-head;
	}
	
	static int empty() {
		if(tail-head==0) return 1;
		else return 0;
	}
	
	static int front() {
		if(tail-head==0) return -1;
		else return dat[head];
	}
	
	static int back() {
		if(tail-head==0) return -1;
		else return dat[tail-1];
	}

}