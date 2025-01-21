import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] a = new int[n];
        
        for(int i=0; i<n; i++){
            a[i] =sc.nextInt();
        }
        
        int f = a[n-1];
        long ans = 0;
        for(int i = n-2; i>=0; i--) {
        	if(a[i]>=f) {
        		ans+= (a[i]-f)+1;
        		f--;
        	}else {
        		f=a[i];
        	}
        }
        
        System.out.println(ans);
        
    }
}
        