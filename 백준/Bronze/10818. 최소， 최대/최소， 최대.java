
import java.util.Scanner;
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int[] arr= new int[N];
		int max= -1000000;
		int min =1000000;
		
		for(int i=0; i<N; i++) {
			arr[i]=in.nextInt();
		}
				
		for(int i=0; i<N; i++)
		{
			if(arr[i]>max) {
				max=arr[i];
			}
			if(arr[i]<min) {
				min=arr[i];
			}
			
		}
		System.out.print(min+" "+max);
		 in.close();
	}
}