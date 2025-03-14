

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[5][15]; // 5줄, 최대 15글자로 가정

        // 배열을 기본값 '\0'으로 초기화할 필요 없음 (Java는 자동으로 초기화)
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j); // 문자열을 배열에 저장
            }
        }

        StringBuilder sb = new StringBuilder();

        // 세로로 읽기
        for (int i = 0; i < 15; i++) { // 최대 길이 15이므로 0~14까지 루프
            for (int j = 0; j < 5; j++) { // 5줄 반복
                if (arr[j][i] != '\0') { // 값이 있을 때만 추가
                    sb.append(arr[j][i]);
                }
            }
        }

        System.out.println(sb.toString()); // 결과 출력
    }
}
