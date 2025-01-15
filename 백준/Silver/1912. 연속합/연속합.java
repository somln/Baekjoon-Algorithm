import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a[] = new int[100001];
		
		for(int i=1; i<=n; i++) {
			a[i]= sc.nextInt();
		}
		
		int maxSum = a[1];
		int currentSum = a[1];
		
		for(int i=2; i<=n; i++) {
			currentSum = Math.max(0, currentSum) + a[i];  //a[i]를 더하기 전의 값이 0보다 작을 경우 a[i]부터 다시 시작
			maxSum = Math.max(currentSum, maxSum);  
		}
		
		System.out.println(maxSum);
		
	}

}