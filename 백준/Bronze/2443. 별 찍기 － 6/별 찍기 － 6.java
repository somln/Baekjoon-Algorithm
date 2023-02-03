import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		for(int i=N; 0<i; i--) {
			for(int j=0; j<N-i; j++ ) {
				System.out.print(" ");
			}
			for(int k=0; k<2*i-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		in.close();	
	}
}
