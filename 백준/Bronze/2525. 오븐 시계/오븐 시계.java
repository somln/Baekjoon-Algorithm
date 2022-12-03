import java.util.Scanner;
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int h = in.nextInt();
		int m = in.nextInt();
		int time = in.nextInt();
		
		in.close();
		
		m=m+time;
		
		while(m>=60) {
			m=m-60;
			h++;
		}
		if(h>=24) {
			h=h-24;
		}
		
		System.out.print(h+" ");
		System.out.print(m);

   }
}