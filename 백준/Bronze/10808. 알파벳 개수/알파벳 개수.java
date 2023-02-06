import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String s = in.next();
		int[] arr = new int[26];
		
		for(int i=0; i<s.length(); i++) {
			arr[s.charAt(i)-'a']++;
		}
		
		for(int a:arr) {
			System.out.print(a+ " ");
		}

		in.close();	
	}
}

