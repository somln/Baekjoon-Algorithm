import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int count=N;
		
		while(N!=0) {
		String s = in.next();
		
		for(int i=0; i<s.length(); i++) {
			if(i!=s.indexOf(s.charAt(i))){  //처음 나오는 알파벳이 아닌데
				if(s.charAt(i)!=s.charAt(i-1)) {  //앞에 알파벳도 같지 않다면
					count--;
					break;
				}
			}
		}
		N--;
	}
	System.out.println(count);
 	    in.close();
	}
}
