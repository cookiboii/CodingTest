

import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int n = sc.nextInt();  // 명령어 개수 입력
        sc.nextLine();  // 개행 문자 제거

        for (int i = 0; i < n; i++) {
            String command = sc.next();  // 명령어 입력

            if (command.equals("push")) {
                int num = sc.nextInt();
                stack.push(num);
            }
            else if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            }
            else if (command.equals("size")) {
                System.out.println(stack.size());
            }
            else if (command.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            }
            else if (command.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek()); // getLast() 대신 peek() 사용
                }
            }
        }
        sc.close();
    }
}
