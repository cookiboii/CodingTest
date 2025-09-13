

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num  = Integer.parseInt(br.readLine());



        for(int a=0;a<num;a++){
            sb.append("*");
            for(int b=num;num>b;b--){}

            System.out.println(sb);
        }


    }
}
