import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		String a = in.next();
		String b = in.next();

		int[] A = new int[26];
		int[] B = new int[26];
		
		int cnt=0;
		
		for(int i=0; i<a.length(); i++) {
			A[a.charAt(i)-'a']++;
		}
		
		for(int i=0; i<b.length(); i++) {
			B[b.charAt(i)-'a']++;
		}
		
		for(int i = 0; i<26; i++) {
			cnt+=Math.abs(A[i]-B[i]);
		}
		
		System.out.println(cnt);
		in.close();	
	}	

}

