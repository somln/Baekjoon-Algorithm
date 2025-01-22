import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[][] f = new int[n][2];
        
        
        for(int i=0; i<n; i++) {
        	int sm = sc.nextInt();  //시작 월
        	int sd = sc.nextInt();  //시작 일
        	int em = sc.nextInt();  //끝 월
        	int ed = sc.nextInt();  //끝 일
        	
        	f[i][0] = sm*100+sd;
        	f[i][1] = em*100+ed;
        }
        
        int t = 301; //현재 시간
        int nxt = 301;
        int ans = 0; //선택한 꽃의 갯수
        
        while(t<1201) {
        	for(int i=0; i<n; i++) {  
        		if(f[i][0]<=t && f[i][1]>nxt) { 
        			nxt = f[i][1];  //현재 시간을 포함하면서 끝나는 시간이 가장 큰 값
        		}
        	}
        	if(nxt==t) {  //현재 시간을 포함하는 값이 없는 경우 -> 만족하는 꽃들을 선택할 수 X
        		System.out.println(0);
        		return;
        	}
        	ans++;
        	t= nxt;
        }
        System.out.println(ans);
        	
    }
}
