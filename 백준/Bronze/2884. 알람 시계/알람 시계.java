
import java.util.Scanner;
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int h = in.nextInt();
		int m = in.nextInt();
		
		if (m>=45) {
			m=m-45;
		}
		else {
			m=m+15;
			h=h-1;
			if(0>h) {
				h=h+24;
			}
		}
		
		System.out.print(h+" ");
		System.out.print(m);
		
	}
 
}