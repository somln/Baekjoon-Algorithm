import java.util.*;
import java.io.*;

public class Main {
	
	static char[] arr;
	static char[] pwd;
	static int c;
	static int l;
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		pwd = new char[l];
		arr = new char[c];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<c; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		
		func(0, 0);
		System.out.println(sb);
		
	}
	
	public static void func(int start, int k) {
		
		if(k==l) {
			int vCnt=0;
			int cCnt=0;
			for(int i=0; i<l; i++) {   //조건을 만족하는지 확인
				if(isVowel(pwd[i])) vCnt++;
				else cCnt++;
			}
			if(vCnt>=1 && cCnt>=2) {  //조건을 만족하는 암호만 출력
				for(int i=0; i<l; i++) {
					sb.append(pwd[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=start; i<c; i++) {
			pwd[k] = arr[i];
			func(i+1, k+1);
		}
	}
	
	static boolean isVowel(char t) {
	    return t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u';
	}

}
