import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String s = in.next();

		for(int i='a'; i<='z'; i++) {
			System.out.print(s.indexOf(i)+" ");
		}
	}
}

