
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        char [][] board = new char[r][c];
        int [][] jd = new int[r][c];
        int [][] fd = new int[r][c];
        
        Queue<Pair> jq = new LinkedList<>();
        Queue<Pair> fq = new LinkedList<>();
        
        for(int i=0; i<r; i++) {
        	String t = br.readLine();
        	for(int j=0; j<c; j++) {
        		board[i][j] = t.charAt(j);
        		if(t.charAt(j)=='J') {
        			jq.offer(new Pair(i,j));
        			jd[i][j]=0;
        		}
        		else if(t.charAt(j)=='F') {
        			fq.offer(new Pair(i,j));
        			fd[i][j]=0;
        		}
        		
        	}
        }
        
        while(!fq.isEmpty()) {
        	Pair fp = fq.poll();
        	
        	for(int k=0; k<4; k++) {
        		int nx = fp.x + dx[k];
        		int ny = fp.y + dy[k];
        		
        		if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            
        		if (board[nx][ny]=='#' || board[nx][ny]=='F' || board[nx][ny]=='J' || fd[nx][ny]>0) continue;
            
        		fd[nx][ny] = fd[fp.x][fp.y]+1;
        		fq.offer(new Pair(nx, ny));
        	}
        }
        
        while(!jq.isEmpty()) {
        	Pair jp = jq.poll();
        	
        	for(int k=0; k<4; k++) {
        		int nx = jp.x + dx[k];
        		int ny = jp.y + dy[k];
        		
        		if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
        			System.out.println(jd[jp.x][jp.y]+1);
        			return;
        		}
            
        		if (board[nx][ny]=='#' || board[nx][ny]=='F' || board[nx][ny]=='J' || jd[nx][ny]>0) continue;
        		
        		if( fd[nx][ny]>0 && jd[jp.x][jp.y]+1 >= fd[nx][ny]) continue;
            
        		jd[nx][ny] = jd[jp.x][jp.y]+1;
        		jq.offer(new Pair(nx, ny));
        	
        	
        	}
        }
        System.out.println("IMPOSSIBLE");
        	
  }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}