import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] s = new int[n];
		
		for(int i=0; i<n; i++) {
			s[i] = sc.nextInt();
		}
		
		Arrays.sort(s);
		
		for(int i=1; i<n; i++) {
			s[i] = s[i] + s[i-1];
		}
		
		int sum=0;
		for(int i=0; i<n; i++) {
			sum+=s[i];
		}
		System.out.println(sum);
		
	}
}
