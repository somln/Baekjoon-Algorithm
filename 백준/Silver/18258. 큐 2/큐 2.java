import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	 static int[] data; 
	 static int head = 0;
	 static int tail = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  StringBuilder sb = new StringBuilder();
		  StringTokenizer st;
		  
		  int N = Integer.parseInt(br.readLine());
		  data = new int[N];
		  
		  for(int i=0; i<N; i++) {
			  st=new StringTokenizer(br.readLine(), " ");
			  
				switch(st.nextToken()) {
				
				case "push":
					push(Integer.parseInt(st.nextToken()));
					break;
					
				case "pop":
					sb.append(pop()+"\n");
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
		  System.out.println(sb.toString());
	}
	
	static void push(int x) {
		data[tail++]=x;
	}
	
	static int pop() {
		if(head==tail) return -1;
		else return data[head++];
	}
	
	static int size() {
		return tail-head;
	}
	
	static int empty() {
		if(tail==head)return 1;
		else return 0;
	}
	
	static int front() {
		if(tail==head) return -1;
		else return data[head];
	}
	
	static int back() {
		if(tail==head) return -1;
		else return data[tail-1];
	}


}
