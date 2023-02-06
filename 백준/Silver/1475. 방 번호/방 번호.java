import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] cnt = new int[10];
		
		while(num!=0) {
			cnt[num%10]++;
			num=num/10;
		}
		cnt[6]=(cnt[9]+cnt[6]+1)/2;
		cnt[9]=0;
		
		System.out.println(Arrays.stream(cnt).max().getAsInt());
			
		in.close();	
	}	

}

