import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int r = in.nextInt();
		int c = in.nextInt();
		int size = (int) Math.pow(2,n);
		System.out.println(func(size,  r, c));
		
	}
	
	public static int func(int size, int r, int c) {
		int half= size/2;
		if (half == 0) {
			return 0;
		}
		if(r<half && c<half) return func(half, r, c);
		if(r<half && c>=half) return half*half + func(half, r, c-half);
		if(r>=half && c<half) return 2*half*half + func(half, r-half, c);
		return 3*half*half + func(half, r-half, c-half);
	}
}