

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         int N = Integer.parseInt(br.readLine());  //스택의 길이
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());// 원소값 푸쉬
            if (num == 0) {  //입력숫자가 0 일떄//비어 있지않으면 꺼낸다
                    stack.pop();
            }
            else{
                stack.push(num); //그렇지않으면 푸쉬한다
            }
        }
      int sum = 0;
        for (Integer i : stack) {
            sum += i;
        }
        System.out.println(sum);
    }
}
