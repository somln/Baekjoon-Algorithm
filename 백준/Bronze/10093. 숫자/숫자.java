import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		
		if(a>b) {
			int tmp=a;
			a=b;
			b=tmp;
		}
		
		if(a==b) System.out.println("0");
		else {
			System.out.println(b-a-1);
		}
		
		for(long i=a+1; i<b; i++) {
			System.out.print(i + " ");
		}
		in.close();	
	}
}