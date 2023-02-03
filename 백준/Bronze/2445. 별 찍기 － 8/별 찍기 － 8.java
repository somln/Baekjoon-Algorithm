import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) {
    	
    
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        
        for (int i = 1; i <= num; i++) {
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            for (int k = 1; k <= 2 * (num - i); k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
 
                System.out.print("*");
            }
 
            System.out.println();
        }
        for (int j = num - 1; j >= 1; j--) {
            for (int k = 1; k <= j; k++) {
                System.out.print("*");
            }
            for (int k = 1; k <= 2 * (num - j); k++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= j; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
 
      }
}