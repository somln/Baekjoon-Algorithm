import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class Main {
	
	static StringBuilder sb;
    public static void main(String args[]) {
    	
        Scanner in = new Scanner(System.in);
        sb = new StringBuilder();
        StringTokenizer st;
        LinkedList<Integer> dq = new LinkedList<Integer>();

        int T = in.nextInt();
        
        while(T!=0) {
        	
           String s = in.next();
           int n = in.nextInt();

           st = new StringTokenizer(in.next(), "[],");
        
           for(int i=0; i<n; i++){
        	   dq.add(Integer.parseInt(st.nextToken()));
          }
           
           ac(s,dq);
           T--;
        }
        System.out.println(sb);
        
    }
    
    static void ac(String s, LinkedList<Integer> dq) {
    	boolean direction=true;
        for(char cmd : s.toCharArray()) {
        	if(cmd=='R'){
        		direction=!direction;
        	}
        	else if(cmd=='D') {
        		if(dq.size()==0) {
        			sb.append("error"+"\n"); 
        			return;
        		}
        		else 
        			if(direction) dq.pollFirst();
        			else dq.pollLast();     		}
        	}
        
    	sb.append('[');

		if(dq.size() > 0) {
			if(direction) {
				sb.append(dq.pollFirst());

				while(!dq.isEmpty()) {
					sb.append(',').append(dq.pollFirst());
				}
			}
			else {
				sb.append(dq.pollLast());

				while(!dq.isEmpty()) {
					sb.append(',').append(dq.pollLast());
				}
			}
		}

		sb.append(']').append('\n');
    }
 
}
 