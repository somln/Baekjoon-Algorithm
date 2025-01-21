import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] s = sc.nextLine().split("-");
 
        int sum=0;
        for(int i=0; i<s.length; i++) {
        	String[] temp = s[i].split("\\+");
        	for(int j=0; j<temp.length; j++) {
        		if(i==0) {
        			sum+=Integer.parseInt(temp[j]);
        		}else {
        			sum-=Integer.parseInt(temp[j]);
        		}
        	}
        }
        
        System.out.println(sum);
    }

}
