import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String argsp[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
        long ans = 0;
        Stack<Long> st = new Stack<>();
        
        while (n-- > 0) {
        	long h = Long.parseLong(br.readLine());
        	
            while (!st.isEmpty() && st.peek() <= h) {
                st.pop();  //나보다 작으면 나를 볼 수 X
            }
            
            ans +=st.size();  //나를 볼 수 있는 건물의 수
            st.push(h);
        }
        
        System.out.println(ans);
	}

}
