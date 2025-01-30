import java.util.*;

public class Main {
	
	static int[][] board1 = new int[21][21];
	static int[][] board2 = new int[21][21];
	static int n;
	static int max = 0;
 	
	public static void main(String argsp[]) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board1[i][j] = sc.nextInt();
			}
		}
		
		//모든 경우의 수는 4의 5승인 1024번
		for(int k=0; k<1024; k++) {
			
			//board2에 board1 복사
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					board2[i][j] = board1[i][j];
				}
			}
			
			int tmp = k;
			
			//해당 경우에 맞게 5번 기울임
			for(int i=0; i<5; i++) {
				int t= tmp % 4;
				tmp = tmp/4;
				
				tilt(t);
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					max = Math.max(max, board2[i][j]);
				}
			}
		}
		
		  System.out.println(max);
	      sc.close();
	}
	
	static void tilt(int dir) {
		
		//기울이는 방향을 다르게 구현하는 대신 board2를 돌리기
		while(dir-->0) rotate();
		
		for(int i=0; i<n; i++) {
			int[] tmp = new int[n];  //한 방향으로 기울였을 때 값 저장
			int idx = 0; //이번에 들어갈 수 있는 자리
			for(int j=0; j<n; j++) {
				
				//board2의 해당 칸이 0이면 다음으로
				if(board2[i][j]==0) {
					continue;
				}
				//지금 들어갈 수 있는 자리가 어차피 빈칸이면 그냥 넣음
				if(tmp[idx]==0) {
					tmp[idx] = board2[i][j];
				}
				else { //지금 들어갈 수 있는 자리에 수가 있을 경우
					if(tmp[idx]==board2[i][j]) {  //그 수랑 같으면 *2
						tmp[idx++]*= 2; 
					}
					else {  // 그 수랑 다르면 그 다음 칸에 넣음
						tmp[++idx] = board2[i][j];
					}
				}
			}
			//tmp에 저장한 값을 다시 board2로 복사
			for(int j=0; j<n; j++) {
				board2[i][j] = tmp[j];
			}
		}
	}
	
	 // board2를 시계 방향으로 90도 회전하는 함수
	static void rotate() {
		
		int[][] tmp = new int[21][21];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				tmp[i][j] = board2[i][j];
 			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board2[i][j] = tmp[n-j-1][i];
			}
		}
	}

}
