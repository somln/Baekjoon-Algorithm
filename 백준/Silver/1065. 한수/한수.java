import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		if(N<100) {
			System.out.println(N);
		}
		else {
			System.out.println(hanNumber(N));
		}
	}

	private static int hanNumber(int n) {
		int check=0;
		for(int i=100; i<=n; i++) {
			int a=i/100;
			int b=(i/10)%10;
			int c=i%10;
			
			if((c-b)==(b-a)) {
				check++;
			}
		}
		return 99+check;
	}
}