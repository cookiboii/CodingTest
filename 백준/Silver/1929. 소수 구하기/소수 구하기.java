

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static int[] isPrime(int m, int n) {
        int[] primes = new int[n + 1];

        // 배열 초기화
        for (int i = 2; i <= n; i++) {
            primes[i] = i;
        }

        // 에라토스테네스의 체 적용
        for (int i = 2; i * i <= n; i++) {
            if (primes[i] != 0) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = 0;
                }
            }
        }
        return primes;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        int[] primes = isPrime(m, n);
        for (int i = m; i <= n; i++) {
            if (primes[i] != 0) {
                sb.append(primes[i]).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
