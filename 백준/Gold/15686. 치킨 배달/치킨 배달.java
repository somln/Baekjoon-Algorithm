import java.util.*;

public class Main {
	
	static int[][] board = new int[55][55];
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static int n, m;
    static int min = Integer.MAX_VALUE;
    static List<int[]> selected = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
				if(board[i][j]==1) house.add(new int[] {i, j});
				if(board[i][j]==2) chicken.add(new int[] {i, j});
			}
		}
		
		func(0, 0);
		System.out.println(min);
		
	}
	
	//치킨집을 선택 후 최소 거리를  계산해서 비교
	static void func(int start, int depth) {
		if(depth == m) {
			min = Math.min(min, calculate());
		}
		
		for(int i=start; i<chicken.size(); i++) {
			selected.add(chicken.get(i));
			func(i+1, depth+1);
			selected.remove(selected.size() - 1);
		}
	}
	
	//최소 거리 계산
	static int calculate() {
		
		 int total = 0;

	        for (int[] h : house) {
	            int minDist = Integer.MAX_VALUE;
	            for (int[] c : selected) {
	                int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
	                minDist = Math.min(minDist, dist);
	            }
	            total += minDist;
	        }
	        return total;
	    }
}
