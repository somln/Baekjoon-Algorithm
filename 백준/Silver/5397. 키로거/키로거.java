import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        if(num < 1 || num > 1000000)
            return;

        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(int i = 0; i < num; i++) {
            String str = br.readLine();
            for(int j = 0; j < str.length();j++) {
                if(str.charAt(j) == '<') {
                    if(!stack.isEmpty())
                        stack2.push(stack.pop());
                } else if(str.charAt(j) == '>') {
                    if(!stack2.isEmpty())
                        stack.push(stack2.pop());
                } else if(str.charAt(j) == '-') {
                    if(!stack.isEmpty())
                        stack.pop();
                } else {
                    stack.push(str.charAt(j));
                }
            }
            while(!stack2.isEmpty())
                stack.push(stack2.pop());

            StringBuffer sb = new StringBuffer();
            while (!stack.isEmpty())
                sb.append(stack.pop());

            bw.write(sb.reverse() + "\n");
        }
        br.close();
        bw.close();
    }
}