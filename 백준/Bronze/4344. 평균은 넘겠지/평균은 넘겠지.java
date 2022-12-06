import java.util.Scanner;
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int C = in.nextInt();
	
		while(C!=0) {
			int sum = 0;
			double count=0;
			double ratio=0;

			int N = in.nextInt(); 
			int[] score =  new int[N];
			
			for(int i=0; i<N; i++) {
				score[i]= in.nextInt();
				sum+=score[i];
			}

			for(int i=0; i<N; i++) {
				if(score[i]>(sum/N)) {
					count++;
				}
			}

			ratio=(double)(count/N)*100;
			System.out.printf("%.3f%%\n",ratio);
			C--;
		}
		in.close();
	}
}