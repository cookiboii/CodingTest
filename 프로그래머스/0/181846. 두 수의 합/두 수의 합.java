import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        // BigInteger를 사용하여 아주 큰 숫자도 처리할 수 있도록 합니다.
        BigInteger number1 = new BigInteger(a);
        BigInteger number2 = new BigInteger(b);
        
        // 두 수를 더합니다.
        BigInteger number3 = number1.add(number2);
        
        // 결과를 문자열로 변환하여 반환합니다.
        return number3.toString();
    }
}
