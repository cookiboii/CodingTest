class Solution {
    public String solution(String s, String skip, int index) {
        String answer = ""; // 결과 문자열을 저장할 변수

        // 입력 문자열 s의 각 문자를 순회
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // 현재 문자를 가져옴

            // 주어진 인덱스 값만큼 문자를 증가시킴
            for (int j = 0; j < index; j++) {
                c += 1; // 문자를 다음 문자로 변경
                if (c > 'z') { // 문자가 'z'를 넘어가면
                    c -= 26; // 'a'로 순환
                }
                // skip 문자열에 현재 문자가 포함되어 있으면 인덱스를 감소시켜 반복을 추가로 실행
                if (skip.contains(String.valueOf(c))) {
                    j--; // skip 문자라면 증가한 횟수를 무효화
                }
            }
            answer += c; // 결과 문자열에 현재 문자를 추가
        }

        return answer; // 최종 결과 문자열 반환
    }
}
