

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 N을 읽음
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        // 두 번째 줄에서 배열 요소들을 읽음
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 세 번째 줄에서 K를 읽음
        int K = Integer.parseInt(br.readLine());

        // 배열을 정렬해야 투 포인터 사용 가능
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == K) {
                count++;
                left++;
                right--;
            } else if (sum < K) {
                left++; // 합이 부족하면 작은 값을 증가
            } else {
                right--; // 합이 크면 큰 값을 감소
            }
        }

        System.out.println(count); // 최종 결과 출력
    }
}
