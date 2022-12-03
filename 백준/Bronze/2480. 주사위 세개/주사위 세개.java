
import java.util.Scanner;
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		
		in.close();
		
		int reward=0;
		
		if((A==B)&(B==C)) {
			reward= 10000 +(A * 1000);
		}
		else if((A==B)||(B==C)) {
			reward=1000 + B * 100;
		}
		else if(A==C) {
			reward=1000 + C * 100;
		}
		else {
			int max;
			if(A>B) {
				if(A>C) {
					max = A;
				}
				else {
					max = C;
				}
			}
			else {
				if(B>C) {
					max =B;
				}
				else {
					max = C;
				}
			}
			reward=100 * max;
		}
		
		System.out.println(reward);

   }
}