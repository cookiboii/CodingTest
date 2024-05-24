class Solution {
    public String solution(String rsp) {
        // 결과를 저장할 StringBuilder 초기화
        StringBuilder result = new StringBuilder();

        // rsp의 각 문자를 순회
        for (char ch : rsp.toCharArray()) {
            // 각 경우에 대해 이기는 수를 추가
            if (ch == '2') {
                result.append('0');  // 가위를 이기려면 바위
            } else if (ch == '0') {
                result.append('5');  // 바위를 이기려면 보
            } else if (ch == '5') {
                result.append('2');  // 보를 이기려면 가위
            }
        }

        // StringBuilder를 문자열로 변환하여 반환
        return result.toString();
    }
}
