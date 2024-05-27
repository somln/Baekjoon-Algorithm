import java.util.*;

public class Main {

    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        
        hanoi(1, 3, n);
        
        System.out.println(count);
        System.out.print(sb.toString());
        
        return;
        
    }
    
    public static void hanoi(int a, int b, int n) {
        
        if (n == 1) { 
            sb.append(a + " " + b + "\n");
            count++;
            return;
        }
    
        hanoi(a, 6 - a - b, n - 1);
        sb.append(a + " " + b + "\n");
        hanoi(6 - a - b, b, n - 1);
        count++;
        
    }
}


/**

* n-1 개의 원판을 기둥 1에서 기둥 2로 옮긴다.
* n번 원판을 기둥 1에서 기둥 3으로 옮긴다.
* n-1개의 원판을 기둥 2에서 기둥 3으로 옮긴다.   -
-> 원판 n-1개일 때를 옮길 수 있으면 n개일 때에도 옮길 수 있다.

원판이 1개일 때 원판을 내가 원하는 곳으로 옮길 수 있다.   
원판이 k개일 때 옮길 수 있으면 원판이 k+1개일 때도 옮길 수 있다.

1. 함수의 정의
void func(int a, int b, int n)
원판 n번 a번 기둥에서 b번 기둥으로 옮기는 방법을 출력하는 함수
2. base Condition
n은 1일 떄 a b 출력
3. 재귀식
* n-1개의 원판을 기둥 a에서 기둥 6-a-b로 옮긴다. func(a, 6-a-b, n-1)
* n번 원판을 기둥 a에서 기둥 b로 옮긴다. println(a+" "+b)
* n-1개의 원판을 기둥 6-a-b에서 기둥 b로 옮긴다. func(6-a-n, b, n-1)
**/