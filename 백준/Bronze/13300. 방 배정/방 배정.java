import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int total = in.nextInt();
		int N = in.nextInt();
		int mw;
		int grade;
		double [] arr = new double[12];
		
		for(int i=0; i<total; i++) {
			mw = in.nextInt();
			grade = in.nextInt();
			if(mw==1) arr[grade-1]++;
			else arr[grade+5]++;
		}
		

		for(int i=0; i<12; i++) {
			arr[i]= Math.ceil(arr[i]/N);
		}
		
		System.out.println((int)Arrays.stream(arr).sum());
		
		in.close();	
	}	

}

