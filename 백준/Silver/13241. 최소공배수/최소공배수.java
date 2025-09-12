

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{




    public static Long gcd(Long a,Long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

    public static Long lcm(Long a, Long b){
        return a*b/gcd(a,b);
    }

    public static void main(String[] args) throws IOException {

         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st=new StringTokenizer(br.readLine());
          Long a= Long.parseLong(st.nextToken());
          Long b= Long.parseLong(st.nextToken());

          StringBuilder sb=new StringBuilder();
          sb.append(lcm(a,b)).append("\n");
          System.out.println(sb);



    }
}
