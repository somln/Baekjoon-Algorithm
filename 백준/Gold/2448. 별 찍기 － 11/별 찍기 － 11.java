import java.util.*;

public class Main {
	
	static char[][] board;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		board = new char[n][2*n-1];
		
		for(int i=0; i<n; i++) {
			Arrays.fill(board[i], ' ');
		}
		
		//맨 위 중앙 꼭짓점부터 시작
		func(0, n-1, n);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<2*n-1; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	//맨 위 꼭짓점을 기준으로 재귀 함수 호출
	public static void func(int x, int y, int size) {
		//3에 도달하면 * 채우기
		if(size==3) {
			board[x][y] = '*';
			board[x+1][y-1] = '*';
			board[x+1][y+1] = '*';
			for (int i = y - 2; i <= y + 2; i++) {
	            board[x + 2][i] = '*';
	        }
			return;
		}
		
		int newSize=size/2;
		//윗 부분 삼각형
		func(x,y,newSize);
		//왼쪽 아래 삼각형
		func(x+newSize, y-newSize, newSize);
		//오른쪽 아래 상각형
		func(x+newSize, y+newSize, newSize);
				
	}
}
