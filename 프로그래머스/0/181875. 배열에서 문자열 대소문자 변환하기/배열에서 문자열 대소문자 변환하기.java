import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (i % 2 == 0) {
                // 짝수번째 인덱스의 문자열은 모두 소문자로 변환합니다.
                strArr[i] = strArr[i].toLowerCase();
            } else {
                // 홀수번째 인덱스의 문자열은 모두 대문자로 변환합니다.
                strArr[i] = strArr[i].toUpperCase();
            }
        }
        return strArr;
    }
}
