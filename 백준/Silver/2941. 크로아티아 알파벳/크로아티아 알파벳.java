import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String[] alpha = new String[] {"dz=", "c=", "z=", "s=", "c-", "d-", "lj", "nj"};
		
		for(int i=0; i<alpha.length; i++) {
			if(s.contains(alpha[i])){
				s=s.replace(alpha[i], "0");
			}
		}

		System.out.println(s.length());

 	     in.close();
	}
}