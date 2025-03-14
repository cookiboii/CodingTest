
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine(); // 문자열 입력 받기

        int[] count = new int[26]; // 알파벳 개수 저장 배열 (0으로 자동 초기화됨)

        // 입력 문자열의 각 문자 개수 세기
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') { // 소문자인 경우만 처리
                count[ch - 'a']++; // 해당 알파벳의 개수 증가
            }
        }

        // 모든 알파벳(a~z) 출력 (없는 문자도 0으로 출력)
        for (int i = 0; i < 26; i++) {
            System.out.println( count[i]);
        }
    }
}
