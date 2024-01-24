
import java.math.BigInteger;

class Solution {
    public int solution(String number) {
        int answer = 0;
        BigInteger num1 = new BigInteger(number);
        
        answer = num1.mod(BigInteger.valueOf(9)).intValue();
        return answer;
    }
}