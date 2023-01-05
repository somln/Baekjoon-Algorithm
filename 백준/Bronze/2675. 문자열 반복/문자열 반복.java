import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		while(T>0) {
			int R = in.nextInt();
			String s = in.next();
			String p = "";
			for(char c : s.toCharArray()) {
				for(int i=0; i<R; i++) {
					p+=c;
				}
			}
			System.out.println(p);
			T--;
		}

	}
}

