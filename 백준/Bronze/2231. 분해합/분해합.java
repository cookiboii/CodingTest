

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
     static int N;

     static int sum;
     static int target;
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());

    for (int i = 1; i < N; i++) {
    target=i;
    sum=target;
       while(target>0){
         sum+=target%10;
         target/=10;
       }

        if(sum==N){

            System.out.println(i);
            return;

        }

    }
     System.out.println(0);

    }
}
