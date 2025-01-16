import java.util.*;

public class Main {
	
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int n = sc.nextInt(); 
	        int[] t = new int[n + 1]; 
	        int[] p = new int[n + 1];
	        int[] d = new int[n + 2]; 

	        for (int i = 1; i <= n; i++) {
	            t[i] = sc.nextInt(); 
	            p[i] = sc.nextInt(); 
	        }

	        // DP 역순 계산
	        for (int i = n; i >= 1; i--) {
	            // i번째 날 상담이 가능한 경우
	            if (i + t[i] <= n + 1) {
	                // 상담을 했을 때와 하지 않았을 때의 최대값 계산
	            	// 지금까지 역순으로 더했던 값과 i 번째날 상담을 하는 경우를 비교
	                d[i] = Math.max(d[i + t[i]] + p[i], d[i + 1]);
	            } else {
	                // 상담이 불가능하면 이전 최대값 유지
	                d[i] = d[i + 1];
	            }
	        }

	        System.out.println(d[1]);

	        sc.close();
	    }

}
