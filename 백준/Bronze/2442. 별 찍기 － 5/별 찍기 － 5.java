import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		for(int i=0; i<N; i++) {
			for(int j=0; j<(2*N-1)/2-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<2*(i+1)-1; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		in.close();	
	}
}