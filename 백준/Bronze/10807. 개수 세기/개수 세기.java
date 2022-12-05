import java.util.Scanner;
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] arr= new int[100];
		int n = in.nextInt();
		int count=0;
		
		for(int i=0; i<n; i++) {
			arr[i]=in.nextInt();
		}
		
		int key = in.nextInt();
		
		for(int i=0; i<n; i++)
		{
			if(arr[i]==key) {
				count++;
			}
		}
		System.out.println(count);

	}
}