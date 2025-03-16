

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        factorize(N);
    }

    public static void factorize(int n) {
        // 2부터 시작하여 나눠 떨어지는 숫자 찾기
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {  // i로 계속 나눌 수 있으면 반복
                System.out.println(i);
                n /= i;
            }
        }

        // 마지막 남은 값이 1보다 크면 소수이므로 출력
        if (n > 1) {
            System.out.println(n);
        }
    }
}
