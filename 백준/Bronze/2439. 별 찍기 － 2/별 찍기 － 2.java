

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num  = Integer.parseInt(br.readLine());


        for (int i = 1; i <= num; i++) {
            // 공백 출력
            for (int j = 0; j < num - i; j++) {
                sb.append(" ");
            }
            // 별 출력
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb);



    }
}
