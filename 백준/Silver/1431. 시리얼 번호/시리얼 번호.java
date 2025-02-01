import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        List<String> arr = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextLine());
        }
        
        arr.sort((a, b)->{
            if(a.length() != b.length()) return a.length() - b.length();
            else {
                int sumA=0;
                int sumB=0;
                for(int i=0; i<a.length(); i++) {
                    int numA = a.charAt(i)-'0';
                    int numB = b.charAt(i)-'0';
                    if(0< numA && numA<10) sumA+=numA;
                    if(0< numB && numB<10) sumB+=numB;
                }
                if(sumA!=sumB) return sumA-sumB;
                return a.compareTo(b);
            }
        });
        
        for(String a : arr) {
        	System.out.println(a);
        }
      
    }
}