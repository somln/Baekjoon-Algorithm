import java.util.*;

public class Main {
	
	
	static long c;

	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		long a = in.nextLong();
		long b = in.nextLong();
		c = in.nextLong();
		
		System.out.println(pow(a, b));
	}
	
	public static long pow(long a, long b) {
		
		if(b==1) return a % c;
		
		long temp = pow(a, b/2);
		if(b%2==1) {
			return temp * temp % c * a % c;
		}
		else {
			return temp * temp % c;
		}
	}
}

/*
 * A^16 = A^8 * A^8 = A^4 * A^4 * A^4 * A^4 = A^2 * A^2 * A^2 * A^2 * A^2 * A^2 * A^2 * ....
 * 
 * 모듈러 합동 공식
 * (a * b) % c = (a % c * b % C) % c
 * (a * a) % c = (a % c * a % C) % c
 * a^b % c = (a % c) * (a % c) *...를 b번 곱하고 % c
 * (a % c) 를 첫 번째 식 A에 대입하여 해당 방식으로 풀이
 * 
 * 귀납적 풀이
 * a^2 % c = (a%c)*(a%c)%c
 * a^b % c = (a%c)를 b번 곱하고 %c
 * */