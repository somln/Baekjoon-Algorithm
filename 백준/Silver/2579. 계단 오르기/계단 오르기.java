import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] s = new int[n+1];
		int[] d = new int[n]; 
		int sum = 0;
		//d[i] = i번째 계단까지 올라섰을 때 밟지 않을 계단 합의 최솟값, 단 i분째 계단든 반드시 밟지 않을 계단으로 선택해야함
		//k번째 계단을 밟지 않았으면 k-1번째 계단은 무조건 밟아야하고, k-2 또는 k-3 중 하나를 무조건 밟아야 함
		
		
		for (int i = 1; i <= n; i++) {
		    s[i] = in.nextInt();
		    sum+=s[i];
		}
		
		
		if (n == 1) {
		    System.out.println(s[1]);
		    return;
		}
		
		if(n ==2 ) {
			System.out.println(s[1]+s[2]);
			return;
		}
        
        if( n == 3 ) {
			System.out.println(Math.max(s[1], s[2]) + s[3]);
			return;
		}
		
		d[1] = s[1];
		d[2] = s[2];
		d[3] = s[3];
		
		
		for(int i=4; i<=n-1; i++) {
			d[i] = s[i] + Math.min(d[i-2], d[i-3]);
		}
		
		//마지막 계단은 무조건 밟아야하기 때문에, 마지막으로 밟지 않은계단은 n-2 혹은 n-1
		System.out.println(sum-Math.min(d[n-1], d[n-2]));

	}

}
