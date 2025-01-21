import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
	       Scanner sc = new Scanner(System.in);
	        
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        
	        int[][] a = new int[n + 1][2];
	        
	        for (int i = 1; i <= n; i++) {
	            a[i][0] = sc.nextInt(); // 무게
	            a[i][1] = sc.nextInt(); // 가치
	        }
	        
	        //dp[i][j]= 1번 물품부터 i번 물품까지 고려했을 때, 배낭의 용량이 j일 때 얻을 수 있는 최대 가치
	        int[][] d = new int[n + 1][k + 1];
	        
	        for(int i=1; i<=n; i++) {
	        	for(int j=1; j<=k; j++) {
	        		if(a[i][0]<=j) { //해당 물품의 무게가 총 용량 j보다 작을 경우
	        			//나를 넣지 않는 경우:  나의 이전 물품까지 고려했을 때의  해당 무게의 최대 가치 //d[i-1][j]
	        			//나를 넣는 경우: 나의 가치 + (해당 무게 - 나의 무게)의 최대 가치  //a[i][1]+d[i-1][j-a[i][0]]
	        			d[i][j] = Math.max(d[i-1][j], a[i][1]+d[i-1][j-a[i][0]]);
	        		}
	        		else {
	        			//해당 물품의 무게가 총 용량 j 보다 크면 아차피 못 넣으니까 이전 값 사용
	        			d[i][j] = d[i-1][j];
	        		}
	        	}
	        }
	        System.out.println(d[n][k]);
	}
}

/*
용량을 k일 때만 고려하고, d[i]는 1번 물품부터 i번 물품까지 따졌을 때의 최대 가치라고 가정
나를 넣을 지 말지 결정
나를 넣을 경우: 이전까지 넣은 값보다 나의 가치 + 나머지 무게의 최대 가치가 커야함
-> 이전 무게의 최대 가치를 알아야 하기 때문에 용량이 1일때 부터  k일때까지 다 계산
*/