import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt();
		
		int[] arr = new int[n];
		int[] result = new int[2000001]; 
		int cnt=0;
		
		for(int i=0; i<n; i++ ) {
			arr[i] = in.nextInt();
		}
		
		int x = in.nextInt();
		
		
		for(int a : arr) {
			if(result[a]!=0) {
				cnt++;
			}
			else {
				if(x-a>0) {
					result[x-a]++;
				}
			}
		}

		System.out.println(cnt);
		
		in.close();	
	}	

}