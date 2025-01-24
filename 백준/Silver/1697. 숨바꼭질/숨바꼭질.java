import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] dist = new int[100002];
        Queue<Integer> qu = new LinkedList<>();
        
        Arrays.fill(dist, -1);  //방문하지 않았다는 것을 표시하기 위해서 모든 값을  -1로
        dist[n] = 0;
        qu.add(n); //시작점을 큐에 삽입
        
        while(dist[k]==-1) {  //목표 지점을 방문하기 전까지 반복
        	int c = qu.poll();
        	for(int nxt : new int[] {c+1, c-1, c*2}) {  //앞으로 or 뒤로 or 순간이동
        		if(nxt<0 || nxt>100000) continue;  // 이동한 후 지정 범위 이상이면 다음으로
        		if(dist[nxt]!=-1) continue; //이미 방문했던 곳이면 다음으로 (최소값을 유지하기 위해)
        		dist[nxt] = dist[c]+1;
        		qu.offer(nxt);
        	}
        }
        
        System.out.println(dist[k]);
        
    }
}