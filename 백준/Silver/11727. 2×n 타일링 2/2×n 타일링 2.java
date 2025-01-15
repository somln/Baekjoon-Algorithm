import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		//d[i] = 2xi 크기의 직사각형을 채우는 방법의 수
		int[] d = new int[1001];
		

		d[1] = 1;
		d[2] = 3;
		
		for(int i=3; i<n+1; i++) {
			d[i] = ( d[i-1] + d[i-2] * 2 ) % 10007;  
		}
		
		System.out.println(d[n]);

	}

}