import java.util.*;

public class Main {
	
	public static void main(String agrs[]) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int[] d = new int[n+1];
		int[] p = new int[n+1];  //이전 값 저장
		
		d[1] = 0;
		p[1] = 0;
		
		for(int i=2; i<=n; i++) {
			d[i] = d[i-1]+1;
			p[i] = i-1;
			
			if(i%2==0 && d[i]> d[i/2]+1) {  //i가 2로 나눠지면서 위에서 저장한 d[i]보다 d[i/2]+1이 작을 경우
				d[i] = d[i/2]+1;
				p[i] = i/2;
			}
			 
			if(i%3==0 && d[i]> d[i/3]+1) {  //i가 3로 나눠지면서 위에서 저장한 d[i]보다 d[i/3]+1이 작을 경우
				d[i] = d[i/3]+1;
				p[i] = i/3;
			}
			
		}
		
		System.out.println(d[n]);
	
		 int cur = n;
	        while (true) {
	            System.out.print(cur + " ");
	            if (cur == 1) break;
	            cur = p[cur];
	        }
	}

}
