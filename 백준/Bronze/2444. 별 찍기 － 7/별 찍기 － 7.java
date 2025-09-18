

import java.io.BufferedReader;
import java.io.IOException;
import java.io. InputStreamReader;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringBuilder sb = new StringBuilder();
          int num = Integer.parseInt(br.readLine());
         for (int i = 1; i <=num ; i++) {
               int space = num - i;
               int stars =2*i -1;
             sb.append(" ".repeat(space));
             sb.append("*".repeat(stars));
             sb.append("\n");
         }

         for (int i = num-1; i >=1 ; i--) {
             int space = num - i;
             int stars =2*i -1;
             sb.append(" ".repeat(space));
             sb.append("*".repeat(stars));
             sb.append("\n");
         }
         System.out.println(sb);

     }
}
