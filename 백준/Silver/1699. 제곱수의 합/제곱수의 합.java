import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int[] d = new int[100001]; 

        d[1] = 1;

        for (int i = 2; i <= n; i++) {
        	double sqrt = Math.sqrt(i);
        	if(sqrt==(int) sqrt){  //제곱근이 있는 경우
        		d[i]=1;
        	}
        	else {
            	d[i] = Integer.MAX_VALUE;
            	for (int j = 1; j < i; j++) {
            		d[i] = Math.min(d[i - j] + d[j], d[i]);
            	}
        	}
        }

        System.out.println(d[n]);
        sc.close();
    }
}

