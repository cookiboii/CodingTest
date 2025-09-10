

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] arr = new int[3];


        for (int i = 0; i <3 ; i++) {
           arr [i] = Integer.parseInt(br.readLine());

        }
       int Muti = arr[0] * arr[1] * arr[2];
        int [] count = new int[10];
        String result = String.valueOf(Muti);
        for (int i = 0; i < result.length(); i++) {

            int digit = result.charAt(i) - '0';
            count[digit]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int c : count) {
            sb.append(c).append("\n");
        }
        System.out.print(sb);

    }
}
