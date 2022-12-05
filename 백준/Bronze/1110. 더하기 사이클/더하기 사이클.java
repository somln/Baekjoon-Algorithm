
import java.util.Scanner;
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		
		 int A =in.nextInt();
		 in.close();
		 
		 int first = A;
		 int last=-1;
		 int left, right, sum, i=0;
		 
		 while(first!=last) {
			 left = A / 10;
			 right = A %10;
			 sum = left + right;
			 
			 A=(right*10)+(sum%10);
			 last=A;
			 i++;
		 }
		 System.out.println(i);
	}
}