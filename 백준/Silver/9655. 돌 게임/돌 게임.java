import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 

        int temp = n%4;
        if(temp%2==0) {
        	System.out.println("CY");
        }
        else {
        	System.out.println("SK");
        }
        sc.close();
    }
}

