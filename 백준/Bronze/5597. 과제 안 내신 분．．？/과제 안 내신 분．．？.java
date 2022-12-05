import java.util.Scanner;
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int[] arr= new int[31];
		
		for(int i=0; i<28; i++) {
			int num = in.nextInt();
			arr[num]=1;
		}
		
		in.close();
		
		for(int i=1; i<31; i++) {
			if(arr[i]!=1) {
				System.out.println(i);
			}
		}
	}
}