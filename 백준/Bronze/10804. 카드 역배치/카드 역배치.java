import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int[] arr = new int[21];
		
		for(int i=1; i<21; i++) {
			arr[i]=i;
		}
		
		for(int i=0; i<10; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			for(int j=0; j<(b-a+1)/2; j++) {
				int temp = arr[a+j];
				arr[a+j] = arr[b-j];
				arr[b-j] = temp;
			}
		}
		for(int i=1; i<21; i++) {
			System.out.print(arr[i] + " ");
		}
		
		in.close();	
	}

}