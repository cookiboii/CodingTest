import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        // 배열을 오름차순으로 정렬
        Arrays.sort(numbers);
  
        // 가장 작은 두 수의 곱 (배열의 첫 두 요소)
        int maxProduct1 = numbers[0] * numbers[1];
        // 가장 큰 두 수의 곱 (배열의 마지막 두 요소)
        int maxProduct2 = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        
        // 이 둘 중 더 큰 값을 반환
        return Math.max(maxProduct1, maxProduct2);
    }
}
