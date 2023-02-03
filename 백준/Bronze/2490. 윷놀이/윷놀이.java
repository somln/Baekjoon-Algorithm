import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String result = "DCBAE";
		int input;

		for(int N=0; N<3; N++) {
			int count=0;
			for(int i=0; i<4; i++) {
				input=in.nextInt();
				count+=input;
			}
			System.out.println(result.charAt(count));
		}
 	    in.close();	
	}
}