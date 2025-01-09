import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		int[] d = new int[11]; // d[i] = i를 1, 2, 3의 합으로 나타내는 방법의 수를 저장하는 배열
		int t = in.nextInt(); 
		
		d[1] = 1; // 1을 만드는 경우의 수: {1}
		d[2] = 2; // 2를 만드는 경우의 수: {1+1, 2}
		d[3] = 4; // 3을 만드는 경우의 수: {1+1+1, 1+2, 2+1, 3}
		
		for(int i=4; i<11; i++) {
			d[i] = d[i-1]+d[i-2]+d[i-3]; 
		}
		
		while(t>0) {
			int n = in.nextInt(); 
			System.out.println(d[n]);
			t--; 
		}
		
	}

}
