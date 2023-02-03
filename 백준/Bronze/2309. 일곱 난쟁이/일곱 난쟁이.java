import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int[] height = new int[9];
		int[] result = new int[7];
		for(int i=0; i<9; i++) {
			height[i]=in.nextInt();
		}
		
		loop:
		//9명 중 2명을 뺀 모든 조합 고려	
		for(int a=0; a<8; a++) {
			for(int b=a+1; b<9; b++) {
				int sum=0;
				
				//나머지 7명 저장
				for(int c=0, i=0; c<9; c++) {
					if(c!=a&&c!=b) {
						result[i++]=height[c]; 
						sum+=height[c];
					}
				}
				if(sum==100) break loop; 
			}
		}
		
		Arrays.sort(result);
		for(int x:result) {
			System.out.println(x);
		}
 	    in.close();	
	}
}

