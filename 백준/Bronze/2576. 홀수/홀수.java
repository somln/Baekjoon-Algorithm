import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int input;
		int sum=0;
		int min=Integer.MAX_VALUE;
		
		for(int i=0; i<7; i++) {
			input = in.nextInt();
			if(input%2!=0) {
				sum+=input;
				if(min>input) min=input;
			}
		}
		
		if(sum==0) System.out.println("-1");
		else {
			System.out.println(sum);
			System.out.println(min);
		}
 	    in.close();	
	}
}
