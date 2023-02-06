import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int[] arr = new int[1000001];
		int[] result = new int[2000001]; 
		int cnt=0;
		
		for(int i=0; i<N; i++) {
			arr[i] = in.nextInt();
		}
		
		int x = in.nextInt();
		
		for(int i=0; i<N; i++) {
			if(x-arr[i]>0&&result[x-arr[i]]==1) cnt++;
			else result[arr[i]]=1;
		}
		System.out.println(cnt);
		
		in.close();	
	}	

}