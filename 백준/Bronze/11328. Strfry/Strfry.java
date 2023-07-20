import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		while(n!=0){
			
			String a = in.next();
			String b = in.next();
			int ac[] = new int[26];
			int bc[] = new int[26];
			for(int i=0; i<a.length(); i++) {
				ac[a.charAt(i)-'a']++;
			}
			
			for(int i=0; i<b.length(); i++) {
				bc[b.charAt(i)-'a']++;
			}
			
			if(Arrays.equals(ac, bc)) System.out.println("Possible");
			else System.out.println("Impossible");
			n--;
			
		}
				
		in.close();

	}

}
