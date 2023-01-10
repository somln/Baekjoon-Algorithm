import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		String s = in.next();
		
		String[] number = new String[] {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
		
		int time=0;
		
		for(char c: s.toCharArray()) {
			for(int i=0; i<number.length; i++) {
				if(number[i].indexOf(c)!=-1) {
					time+=i+3;
					break;
				}
			}
		}
		System.out.println(time);
 	     in.close();
	}

}
