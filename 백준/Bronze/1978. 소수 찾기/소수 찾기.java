import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 배열의 길이
        int count = 0;
        int[] arr = new int[n];

        // 배열 입력 받기
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 배열 요소 중 소수 개수 찾기
        for (int num : arr) {
            if (isPrime(num)) {
                count++;
            }
        }

        System.out.println(count);
    }

    // 소수 판별 함수
    public static boolean isPrime(int num) {
        if (num < 2) return false; // 0, 1은 소수가 아님
        for (int i = 2; i * i <= num; i++) { // √num까지만 검사
            if (num % i == 0) return false;
        }
        return true;
    }
}


