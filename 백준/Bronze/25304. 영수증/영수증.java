
import java.util.Scanner;
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int total = in.nextInt();
		int n = in.nextInt();
		int sum=0;
		
		for(int i=0; i<n; i++) {
			int price = in.nextInt();
			int num = in.nextInt();
			sum+=price*num;
		}
		
		if(sum==total) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}

   }
}