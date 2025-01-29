import java.util.*;

public class Main {
	
	static int board[][];
	static int[][] st; 
	static int n, m, r, c;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		int k = sc.nextInt();
		
		
		board = new int[n][m];
		
		while(k-->0) {
			r = sc.nextInt();
			c = sc.nextInt();
			
			st = new int[r][c];
					
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					st[i][j] = sc.nextInt();
				}
			}
			
			outer:
			for(int g=0; g<4; g++) {
				for(int i=0; i<=n-r; i++) {
					for(int j=0; j<=m-c; j++) {
						if(pastable(i, j)) {
							break outer;
						}
					}
				}
				//끝까지 다 탐색해봐도 자리가 없으면 회전
				rotate();
			}
			
			
		}
		
		  int cnt = 0;
	        for (int i = 0; i < n; i++)
	            for (int j = 0; j < m; j++)
	                cnt += board[i][j];
	        
	        System.out.println(cnt);
	        sc.close();
		
	}
	
	static boolean pastable(int x, int y) {
		
		//스티커를 붙일 수 있는 지 확인
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(board[i+x][j+y]==1 && st[i][j]==1) {
					return false;
				}
			}
		}
		
		//붙일 수 있으면 붙임
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(st[i][j]==1) {
					board[i+x][j+y]=1;
				}
			}
       }
		return true;
	}
	
	public static void rotate() {
	    int[][] tmp = new int[r][c];
	    
	    // 원본 배열 복사
	    for (int i = 0; i < r; i++) {
	        System.arraycopy(st[i], 0, tmp[i], 0, c);
	    }
	    
	    // 차원이 바뀐 새 배열 생성
	    st = new int[c][r]; 
	    
	    // 90도 회전 수행
	    for(int i = 0; i < c; i++) {
	        for(int j = 0; j < r; j++) {
	            st[i][j] = tmp[r-1-j][i];
	        }
	    }
	    
	    // 차원 업데이트
	    int temp = r;
	    r = c;
	    c = temp;
	}
}
