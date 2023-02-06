import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		int mul = a*b*c;
		int[] arr = new int[10];
		
		while(mul!=0) {
			arr[mul%10]++;
			mul=mul/10;
		}
		
		for(int x : arr) {
			System.out.print(x + " ");
		}
		
		in.close();	
	}
	

}