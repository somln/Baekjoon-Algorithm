import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		int a = in.nextInt();
		int b = in.nextInt();
		
		int A = a%10*100+a/10%10*10+a/100;
		int B = b%10*100+b/10%10*10+b/100;
		
		System.out.println(Math.max(A, B));
	     in.close();
	}
}
