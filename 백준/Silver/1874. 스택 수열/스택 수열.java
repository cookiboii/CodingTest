
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int current =1;

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < N; i++) {
             int num = arr[i];
             while( current <=num){
                 stack.push(current);
                 sb.append("+\n");
                 current++;
             }
             if(stack.peek()==num){
                 stack.pop();
                 sb.append("-\n");
             }
             else{
                 flag = false;
                 break;
             }

        }
        if(flag){
            System.out.println(sb);
        }
        else{
            flag=false;
            System.out.println("NO");
        }

    }
}
