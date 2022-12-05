import java.util.Scanner;
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int[] arr= new int[10];
		int[] remainder = new int[42];
		int num, count=0;
		
		for(int i=0; i<10; i++) {
			arr[i] = in.nextInt();
		}
		
		in.close();
		
		for(int i=0; i<10; i++) {
			num = arr[i]%42;
			remainder[num]=1;
		}
 
		for(int i=0; i<42; i++) {
			if(remainder[i]==1) {
				count++;
			}
		}
		System.out.println(count);
	}
}