import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        List<int[]> s = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
        	int start = sc.nextInt();
        	int end = sc.nextInt();
        	s.add(new int[] {start, 1});  //강의가 시작되면 강의실을 1개 이용
        	s.add(new int[] {end, -1});   //강의가 끝나면 강의실을 1개 반납
        }
        
        //시작 시간이 같으면 끝나는 시간이 빠른 순으로, 그렇지 않으면 시작시간이 빠른 순으로 정렬
        s.sort((s1, s2)->s1[0]==s2[0]? s1[1]-s2[1] : s1[0]-s2[0]);
        
        int current=0;
        int max=0;
        for(int[] c: s) {
        	current+=c[1];   //강으 시작이면 강의실 +1, 종료면 -1
        	max = Math.max(max, current);  //최댓값 갱신
        }
        
        System.out.println(max);
    }

}
