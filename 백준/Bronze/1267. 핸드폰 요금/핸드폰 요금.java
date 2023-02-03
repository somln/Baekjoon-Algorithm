import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int input;
		int sum1=0, sum2=0;
		
		for(int i=0; i<N; i++) {
			input = in.nextInt();
			sum1+=(input/30+1)*10;
			sum2+=(input/60+1)*15;
		}
		
		if(sum1>sum2) {
			System.out.println("M"+ " " + sum2);
		}
		else if(sum2>sum1) {
			System.out.println("Y"+ " " + sum1);
			
		}
		else {
			System.out.println("Y"+ " " +"M"+ " " + sum1);
		}
		in.close();	
	}

}