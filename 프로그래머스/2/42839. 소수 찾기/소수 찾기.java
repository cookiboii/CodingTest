import java.util.*;

class Solution {
    // 소수 판별 함수
    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 모든 가능한 숫자 조합 생성 함수
    public void generateNumbers(String prefix, String remaining, Set<Integer> numberSet) {
        if (!prefix.isEmpty()) {
            numberSet.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < remaining.length(); i++) {
            generateNumbers(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), numberSet);
        }
    }

    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> numberSet = new HashSet<>();
        generateNumbers("", numbers, numberSet);
        for (int num : numberSet) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("17")); // 3
        System.out.println(sol.solution("011")); // 2
    }
}
