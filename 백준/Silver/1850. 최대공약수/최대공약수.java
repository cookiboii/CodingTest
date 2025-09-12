

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static Long gcd(Long a,Long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
          Long a = Long.parseLong(st.nextToken());
          Long b = Long.parseLong(st.nextToken());
          long gcd = gcd(a,b);
        for (long i = 0; i <gcd ; i++) {
            sb.append('1');
        }
     System.out.println(sb);

    }
}
